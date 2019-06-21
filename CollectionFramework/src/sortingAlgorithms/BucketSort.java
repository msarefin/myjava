package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BucketSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		displayArray(arr);

		sort(arr);
		displayArray(arr);
	}

	private static int[] initializeArray(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}

	private static void displayArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}

	private static int maxArray(int arr[]) {
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}

	private static void sort(int arr[]) {

		int max = maxArray(arr); // Find maximum value of the array

		System.out.println("maximum value in array  = " + max);

		int nbkts = (int) Math.sqrt(arr.length); // Determine the number of buckets

		Buckets bucket[] = new Buckets[nbkts]; //Initialize buckets array

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new Buckets(); // instanciate Buctets class 
		}

		for (int n : arr) {
			int bi = n * nbkts / (max + 1); // bucket index number based on the value. 
			bucket[bi].bucket.add(n);

		}

		System.out.println();

//		for (Buckets n : bucket) {
//			System.out.print("Bucket ");
//			for (int val : n.bucket) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		for (Buckets b : bucket) {
			for (int i = 0; i < b.bucket.size() - 1; i++) {
				int p = i;
				while (p >= 0 && b.bucket.get(p) > b.bucket.get(p + 1)) {
					int temp = b.bucket.get(p);
					b.bucket.set(p, b.bucket.get(p + 1));
					b.bucket.set(p + 1, temp);

					p--;
				}
			}
		}

//		System.out.println();
//
//		for (Buckets n : bucket) {
//			System.out.print("Bucket ");
//			for (int val : n.bucket) {
//				System.out.print(val + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		int index = 0;
		for (Buckets n : bucket) {
			for (int val : n.bucket) {
				arr[index] = val;
				index++;
			}
		}

	}
}

class Buckets {
	ArrayList<Integer> bucket = new ArrayList<Integer>();
}
