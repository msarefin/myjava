package Practicing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bucket_Sort {

	private static int[] arr = new int[] { 5, 7, 3, 9, 1, 8, 2, 6, 4, 0, -5, -8, -2, -3, -9, -1, -6, -4, -7 };

	public static void main(String[] args) {
		bucketSort(arr);

	}

	private static void bucketSort(int[] arr) {
		String method = new Throwable().getStackTrace()[0].getMethodName().toString();
		System.out.println(method + "\n" + "=".repeat(method.length()));
		printArray(arr);

		int max = 0;
		int min = 0;

		int nas = 0;
		int pas = 0;

		for (int n : arr) {
			if (n < 0) {
				nas++;
				if (min > n)
					min = n;
			} else {
				pas++;
				if (max < n)
					max = n;
			}
		}

		int nbs = (int) Math.sqrt(nas);
		int pbs = (int) Math.sqrt(pas);

		System.out.println("max\t" + max + "\nmin\t" + min + "\nnas\t" + nas + "\npas\t" + pas + "\nnbs\t" + nbs
				+ "\npbs\t" + pbs);

		List[] nBucket = new List[nbs];
		List[] pBucket = new List[pbs];

		for (int i = 0; i < nBucket.length; i++) {
			nBucket[i] = new ArrayList();
		}
		for (int i = 0; i < pBucket.length; i++) {
			pBucket[i] = new ArrayList();
		}

		for (int n : arr) {
			int bi = 0;

			if (n < 0) {
				bi = (n * nbs) / (min - 1);
				nBucket[bi].add(n);

			} else {
				bi = (n * pbs) / (max + 1);
				pBucket[bi].add(n);
			}
		}

		System.out.println(Arrays.toString(nBucket));
		System.out.println(Arrays.toString(pBucket));

		for (List bkt : nBucket) {
			for (int i = 1; i < bkt.size(); i++) {
				int t = (int) bkt.get(i);
				int j = i - 1;
				while (j >= 0 && (int) bkt.get(j) > t) {
					if ((int) bkt.get(j) > t) {
						bkt.set(j + 1, bkt.get(j));
						j--;
					}
					bkt.set(j + 1, bkt.get(j));
				}
			}
		}

		printArray(arr);

	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}