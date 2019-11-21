package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class BucketSort {

	static int range = 100;
	static int size = factor(range);
	static int[] arr = new int[size];

	public static void main(String[] args) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(range);
		}

		System.out.println(Arrays.toString(arr));

		bucketSort(arr);
	}

	static void bucketSort(int[] arr) {
		int temp = 0;

//		Find the Largest number in the array 
		for (int i = 0; i < arr.length; i++) {
			if (temp < arr[i]) {
				temp = arr[i];
			}
		}

		System.out.println("Largest number in the array: " + temp);

//		Determine the number of buckets
		int d = factor(arr.length);
		int ind = arr.length / d;
		System.out.println("Number of buckets: " + ind);

//		 Declaring Array of buckets
		List[] bucket = new List[ind];

		String[][] bkt = new String[ind][arr.length];

//		 Initialize buckets
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList();

		}

//		 Adding elements to buckets
		for (int n : arr) {
//			Determining bucket index
			int bi = n * ind / (temp + 1);
			bucket[bi].add(n);
		}

		for (int i = 0; i<arr.length; i++) {
			int bi = arr[i] * ind / (temp + 1);
			bkt[bi][i] = Integer.toString(arr[i]);
		}

		for (int i = 0; i < bkt.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(bkt[i][j] + " ");
			}
			System.out.println();
		}

//		 Show Elements in buckets
		for (List b : bucket) {
			System.out.println("Bucket: " + b);
		}

	}

	static int factor(int n) {
		ArrayList f = new ArrayList();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				f.add(i);
			}
		}
		int sum = 0;
		Iterator it = f.iterator();
		while (it.hasNext()) {
			sum = sum + (int) it.next();
		}
		int avgFactor = sum / f.size();
		return avgFactor;
	}

}
