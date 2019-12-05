package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	static int arr[];
	static int size = 1000;
	static int bound = 1000;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int arr[] = new int[] { 6, 1, 2, 7, 12, 3, 8, 4, 9, 5, 0, 10, -1, -3, -2 };
		//		System.out.println("The Array before Sorting");
		displayArray(arr);
//
		QuickSort(arr);
//		System.out.println("The Array after Sorting");
		displayArray(arr);

		long stop = System.currentTimeMillis();
		System.out.println(stop - start);

	}

	private static void QuickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int arr[], int low, int high) {
		if (low < high) {

			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	private static int partition(int arr[], int low, int high) {

		int p = low + (high - low) / 2;
		int pivot = arr[p];
		swap(arr, p, high);
		int i = low - 1;

		for (int j = low; j < high; j++) {

			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i + 1;
	}

	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}

	private static void displayArray(int arr[]) {

		System.out.println(Arrays.toString(arr));
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
