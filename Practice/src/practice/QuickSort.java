package practice;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	static int arr[];
	static int size = 11;
	static int bound = 100;

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 1, 6, 2, 7, 3, 8, 4, 9, 0 };
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}

	static void quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		partitioning(arr, 0, arr.length - 1);
	}

	static void partitioning(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int pi = low + (high - low) / 2;
		int pivot = arr[pi];
		swap(arr, pi, high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
//				System.out.println(arr[j] + "<" + pivot);
				i++;
				if (i != j) {

					swap(arr, i, j);
				}

			}
		}
//		System.out.println("Swapping: " + arr[i + 1] + " <-> " + arr[high]);
		swap(arr, i + 1, high);
		pi = i + 1;
		partitioning(arr, low, pi - 1);
		partitioning(arr, pi + 1, high);
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
