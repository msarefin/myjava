package practice;

import java.awt.DisplayMode;
import java.util.Arrays;

public class QuickSort {

	private int[] numbers;

	private int number;

	public static void main(String[] args) {

		int arr[] = new int[] { 5, 8, 2, 7, 3, 9, 1, 6, 4, 0, -1, -2, -3 };
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

	static void quickSort(int[] arr) {
		partitioning(arr, 0	, arr.length-1);
	}

	

	static void partitioning(int[] arr, int low, int high) {
		if (low > high ) {
			return;
		}
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);

			}
		}
		swap(arr, i + 1, high);
		printArray(arr);
		int p = i + 1;
		
		partitioning(arr, low, p - 1);
		partitioning(arr, p + 1, high);

	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
