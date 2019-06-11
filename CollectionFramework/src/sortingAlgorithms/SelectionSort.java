package sortingAlgorithms;

import java.util.Random;

public class SelectionSort {

	private static int ar[];
	
	public static void main(String[] args) {


		ar = initializeArray(10, 50, ar);
		printArray(ar);
		SelectionSort(ar);
		printArray(ar);
		
		
		
	}

	private static void SelectionSort(int arr[]) {
		int attempt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					attempt++; 
					System.out.print(attempt+" : ");
					printArray(arr);
				}
			}
		}

	}

	private static int[] initializeArray(int size, int range, int[] arr) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(range);
		}

		return arr;
	}

	private static void printArray(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}

		System.out.println();
	}

	

}
