package sortingAlgorithms;

import java.util.Random;

public class QuickSort {

	static int arr[];
	static int size = 11;
	static int bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		displayArray(arr);

		sort(arr, 0, arr.length - 1);

		displayArray(arr);

	}

	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}

	private static void displayArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
//			System.out.print(i + " \t");
		}
		System.out.println();

		for (int n : arr) {

			System.out.print(n + " ");
		}

		System.out.println();
	}

	private static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		System.out.println("Pivot is " + pivot);

		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {

				i++;
//				System.out.println("i = " + i + " j = " + j + " : " + arr[j] + " is less than pivot");
//				System.out.println("Swapping " + arr[i] + " with " + arr[j] + "\n");
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				displayArray(arr);

			}

		}

//		System.out.println("Swapping " + arr[i + 1] + " with " + arr[high] + "\n");
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		displayArray(arr);
		return i + 1;
	}

	private static void sort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

}
