package sortingAlgorithms;

import java.util.Random;

public class QuickSort {

	static int arr[];
	static int size = 11;
	static int bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		System.out.println("The Array before Sorting");
		displayArray(arr);

		QuickSort(arr);
		System.out.println("The Array after Sorting");
		displayArray(arr);

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
		int pivot = arr[high];
		System.out.println("Pivot is " + pivot);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
				displayArray(arr);
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
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
