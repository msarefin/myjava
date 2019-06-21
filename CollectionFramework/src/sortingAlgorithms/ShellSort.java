package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	public static void main(String[] args) {

		arr = initializeArray(arr, size, bound);
		displayArray(arr);
		shellSort(arr);
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

	private static void shellSort(int arr[]) {
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];

				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
					arr[j] = arr[j - gap];

				arr[j] = temp;
			}
		}
		
	}
}
