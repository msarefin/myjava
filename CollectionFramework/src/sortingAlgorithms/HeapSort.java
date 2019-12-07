package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

	private static int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	private static int size = 15;
	private static int bound = 100;

	public static void main(String[] args) {
//		arr = initializeArray(arr, size, bound);
		displayArray(arr);

		sort(arr);

		displayArray(arr);
	}

	private static int[] initializeArray(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}

	private static void displayArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}

	private static void heapify(int arr[], int n, int i) {

		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest]) {

			largest = l;

		}

		if (r < n && arr[r] > arr[largest]) {

			largest = r;

		}

		if (largest != i) {

			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			displayArray(arr);
			heapify(arr, n, largest);

		}

	}

	private static void sort(int arr[]) {
		int n = arr.length;
		System.out.println("Create a heap");
		for (int j = n / 2 - 1; j >= 0; j--) {
			System.out.println(j);
			heapify(arr, n, j);

		}

		System.out.println("delete the heap and sort");
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			displayArray(arr);
			heapify(arr, i, 0);

		}
	}

}
