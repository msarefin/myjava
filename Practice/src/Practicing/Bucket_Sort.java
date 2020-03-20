package Practicing;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Bucket_Sort {

	private static int[] arr = new int[] { 5, 7, 3, 9, 1, 8, 2, 6, 4, 0, -5, -8, -2, -3, -9, -1, -6, -4, -7 };

	public static void main(String[] args) {
		bucketSort(arr);
		System.out.println("Sorted Array:");
		printArray(arr);
	}

	private static void bucketSort(int[] arr) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(methodName + "\n" + "=".repeat(methodName.length()));
		printArray(arr);

		int min = 0;
		int max = 0;
		int ne = 0;
		int pe = 0;

		for (int n : arr) {
			if (n < 0) {
				ne++;
				if (min > n) {
					min = n;
				}
			} else {
				pe++;
				if (max < n) {
					max = n;
				}
			}
		}

		int nb = (int) Math.sqrt(ne);
		int pb = (int) Math.sqrt(pe);

		List[] nBucket = new List[nb];
		List[] pBucket = new List[pb];

		nBucket = initializeBucket(nBucket);
		pBucket = initializeBucket(pBucket);
		
		for(int n :arr) {
			int bi = 0; 
			if(n<0) {
				bi = (n*nb)/(min-1);
				nBucket[bi].add(n);
			}else {
				bi = (n*pb)/(max+1);
				pBucket[bi].add(n); 
			}
		}
		
		insertionSort(nBucket);
		insertionSort(pBucket);
		
		int index= 0; 
		for(int i = nBucket.length-1; i>=0; i--) {
			for(int j = 0 ; j< nBucket[i].size(); j++) {
				arr[index++] = (int)nBucket[i].get(j); 
			}
		}
		for(int i = 0; i< pBucket.length; i++) {
			for (int j = 0; j < pBucket[i].size(); j++) {
				arr[index++] = (int)pBucket[i].get(j);
			}
		}

	}
	
	private static void insertionSort(List[] buckets ) {
		for(List bkt : buckets) {
			for(int i = 1; i<bkt.size(); i++) {
				int temp = (int)bkt.get(i);
				int j = i-1; 
				while(j>=0 && (int)bkt.get(j)>temp) {
					if((int)bkt.get(j)>(int)bkt.get(j+1)) {
						bkt.set(j+1, bkt.get(j));
						j--;
					}
					bkt.set(j+1, temp);
				}
			}
		}
	}

	private static List[] initializeBucket(List[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList();
		}
		return buckets;
	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}