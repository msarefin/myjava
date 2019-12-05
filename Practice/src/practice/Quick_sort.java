package practice;

import java.util.Arrays;
import java.util.Random;

public class Quick_sort {

	static int arr[];
	static int size = 1000;
	static int bound = 1000;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int arr[] = new int[] { 6, 1, 2, 7, 12, 3, 8, 4, 9, 5, 0, 10, -1, -3, -2 };
		printArray(arr);
		quickSort(arr);
		printArray(arr);
		long stop = System.currentTimeMillis();

		System.out.println(stop - start);

	}

	static void quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		partition(arr, 0, arr.length - 1);
	}

	static void partition(int[] arr, int low, int high) {

		int i = low, j = high;
		int p = low + (high - low) / 2;
		int pivot = arr[p];

		while (i <= j) {

			while (arr[i] < pivot) {

				i++;
			}
			while (arr[j] > pivot) {

				j--;
			}
			if (i <= j) {

				swap(arr, i++, j--);

			}
		}
		if (low < j) {
			partition(arr, low, j);
		}
		if (i < high) {
			partition(arr, i, high);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}
}
