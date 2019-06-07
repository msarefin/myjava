package sortingAlgorithms;

import java.util.Random;

public class BubbleSort {

	private static int ar[];

	private static void BubbleSort(int arr[]) {

		int attempt = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					attempt++;
					System.out.print(attempt + " : ");
					printArray(arr);
				}
			}
		}

	}

	private static void rBubbleSort(int[] arr, int n) {
		// recursive bubble sort
		if (n == 1)
			return;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}

			printArray(ar);

		}

		rBubbleSort(arr, n - 1);
	}

	private static int[] randomValues(int size, int range, int[] arr) {

		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(range);
		}

		return arr;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		ar = randomValues(10, 100, ar);
		printArray(ar);
		BubbleSort(ar);

		ar = randomValues(10, 100, ar);
		printArray(ar);
		rBubbleSort(ar, ar.length);

		
	}

}
