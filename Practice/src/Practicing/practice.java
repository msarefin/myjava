package Practicing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class practice {

	final static int[] arr = new int[] { 3, 7, 1, 9, 6, 4, 8, 2, 5, 0, -2, -5, -1, -3 };

	public static void main(String[] args) {
		practice p = new practice();
		printArray(arr);
		System.out.println();
//		int[] bubbleSort = ar(arr);
//		int[] selectionSort = ar(arr);
//		int[] insertionSort = ar(arr);
		int[] bucketSort = ar(arr);
//		int[] mergeSort = ar(arr);

//		bubbleSort(bubbleSort);
//		selectionSort(selectionSort);
//		insertionSort(insertionSort);
		bucketSort(bucketSort);
//		mergeSort(mergeSort);

	}

	// ---------------------------------------------sorting
	// algorithms-------------------------------

	public static void bubbleSort(int[] arr) {
//		String methodName = new Object() {
//		}.getClass().getEnclosingMethod().getName();
//		System.out.println(methodName);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				int f = j, l = j + 1;
				if (arr[f] > arr[l]) {
					swap(arr, f, l);

				}
			}
		}
		printArray(arr);
	}

	static void selectionSort(int[] arr) {
//		String methodName = new Object() {
//		}.getClass().getEnclosingMethod().getName();
//		System.out.println(methodName);

		for (int i = 0; i < arr.length - 1; i++) {
			int p = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[p]) {
					p = j;
				}
			}

			swap(arr, i, p);
			printArray(arr);
		}
		printArray(arr);
	}

	static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > t) {

				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}
		printArray(arr);
	}

	static void bucketSort(int[] arr) {
		int maxValue = 0;

//		Find the Largest number in the array 
		for (int i = 0; i < arr.length; i++) {
			if (maxValue < arr[i]) {
				maxValue = arr[i];
			}
		}

		System.out.println("Largest number in the array: " + maxValue);

//		Determine the number of buckets
//		int avarageFactor = factor(arr.length);
		int numberOfBuckets = (int) Math.sqrt(arr.length);
		System.out.println("Number of buckets: " + numberOfBuckets);

//		 Declaring Array of buckets
		List[] bucket = new List[numberOfBuckets];

//		 Initialize buckets
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList();
		}

//		 Adding elements to buckets
		for (int n : arr) {
//			Determining bucket index
			int bi = n * numberOfBuckets / (maxValue + 1);
			bucket[bi].add(n);
		}

//		 Show Elements in buckets
		for (List b : bucket) {
			System.out.println("Bucket: " + b);
		}

//		Sort Elements in the Bucket
		for (int i = 0; i < bucket.length; i++) {
			Collections.sort(bucket[i]);
		}

		System.out.println("**********************Sorted Buckets***********************************");

//		 Show Elements in buckets
		for (List b : bucket) {
			System.out.println("Bucket: " + b);
		}

//		Replacing the array with the buckets in a sequence 
		int index = 0;

		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				arr[index++] = (int) bucket[i].get(j);
			}
		}

		printArray(arr);
	}

	static void mergeSort(int[] arr) {
		printArray(arr);
		if (arr == null) {
			return;
		}
		if (arr.length > 1) {
			int mid = arr.length / 2;
			// Split left part
			int[] left = new int[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = arr[i];
			}
			// Split right part
			int[] right = new int[arr.length - mid];
			for (int i = mid; i < arr.length; i++) {
				right[i - mid] = arr[i];
			}
			mergeSort(left);
			mergeSort(right);
			int i = 0;
			int j = 0;
			int k = 0;
			// Merge left and right arrays
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					arr[k++] = left[i++];
				} else {
					arr[k++] = right[j++];
				}
			}
			// Collect remaining elements
			while (i < left.length) {
				arr[k++] = left[i++];

			}
			while (j < right.length) {
				arr[k++] = right[j++];

			}
		}
		
	}

	// ----------------------------------Other-tools------------------------------------------

	static int[] ar(int[] arr) {
		int a[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = arr[i];
		}
		return a;
	}

	static void swap(int[] arr, int f, int l) {
		int t = arr[f];
		arr[f] = arr[l];
		arr[l] = t;
	}

	static void printArray(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
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
