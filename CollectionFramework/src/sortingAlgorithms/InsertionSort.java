package sortingAlgorithms;

import java.util.Random;

public class InsertionSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	public static void main(String[] args) {
		arr = initialization(arr, size, bound);
		displayArray(arr);
		insertionSort(arr);
		displayArray(arr);
		
		System.out.println();

		arr = initialization(arr, size, bound);
		displayArray(arr);
		rInsertionSort(arr, size);
		displayArray(arr);

	}

	static int[] initialization(int[] arr, int size, int bound) {

		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);

		}

		return arr;
	}

	private static void displayArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void insertionSort(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	private static void rInsertionSort(int arr[], int n) {

		if (n <= 1)
			return;

		rInsertionSort(arr, n - 1);

		int key = arr[n - 1];

		int j = n - 2;

		while (j >= 0 && arr[j] > key) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = key;

	}

}
