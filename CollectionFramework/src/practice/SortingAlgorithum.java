package practice;

import java.util.Random;

import sortingAlgorithms.BubbleSort;

public class SortingAlgorithum {

	private static int[] arr;
	private static int size = 10;
	private static int range = 100;

	public static void main(String[] args) {

		bubbleSort b = new bubbleSort();
		selectionSort s = new selectionSort();
		insertionSort is = new insertionSort();

//		arr = setupArray(arr, size, range);
//		int []arr1 = {10, 9, 8, 7, 6, 5, 4,3, 2, 1};
//		displayArray(arr);
//		b.BubbleSort(arr);
//		displayArray(arr);

//		arr = setupArray(arr, size , range);
//		displayArray(arr);
//		b.rBubbleSort(arr, arr.length);
//		displayArray(arr);

//		arr = setupArray(arr, size, range);
//		displayArray(arr);
//		s.SelectionSort(arr);
//		displayArray(arr);

		arr = setupArray(arr, size, range);
		displayArray(arr);
		is.insertionSort(arr);
		displayArray(arr);

	}

	static int[] setupArray(int[] arr, int size, int range) {

		arr = new int[size];
		Random r = new Random();

		for (int i = 0; i < size; i++) {
			arr[i] = r.nextInt(range);
		}

		return arr;
	}

	static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}

class bubbleSort {

	void BubbleSort(int[] arr) {

		System.out.println("Bubble sort");

		int id = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					id++;
					System.out.print(i + " :: " + id + " : ");

					for (int a = 0; a < arr.length; a++) {
						System.out.print(arr[a] + " ");
					}

					System.out.println();

				}
			}

		}

	}

	void rBubbleSort(int[] arr, int n) {

		System.out.println("Recursive Bubble sort");

		int id = 0;

		if (n == 1)
			return;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;

//				id++;
//				System.out.print(i+" :: "+id + " : ");
//
//				for (int a = 0; a < arr.length; a++) {
//					System.out.print(arr[a] + " ");
//				}
//
//				System.out.println();
			}
		}

		rBubbleSort(arr, n - 1);
	}

}

class selectionSort {

	{
		System.out.println("Selection  sort");
	}

	void SelectionSort(int[] arr) {
		int id = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					id++;
					System.out.print(i + " :: " + id + " : ");

					for (int a = 0; a < arr.length; a++) {
						System.out.print(arr[a] + " ");
					}

					System.out.println();
				}
			}
		}
	}

}

class insertionSort {

	void insertionSort(int[] arr) {

		int id = 0;

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;

			id++;
			System.out.print(i + " :: " + id + " : ");

			for (int a = 0; a < arr.length; a++) {
				System.out.print(arr[a] + " ");
			}

			System.out.println();
		}

	}

	void rInsertionSort(int[] arr, int n) {

		int id = 0; 
		
		if (n <= 0)
			return;

		rInsertionSort(arr, n - 1);
		int key = arr[n - 1];

		int j = n - 2;

		while (j >= 0 && arr[j] > key) {
			arr[j] = arr[j + 1];
			j--;
		}
		arr[j + 1] = key;
		
		
		id++; 
		System.out.print(id+" :: ");
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
