package a_Practice;

import java.util.Arrays;
import java.util.Random;

public class JustPractice {

	int[] arr = new int[] { 9, 1, 8, 2, 7, 3, 6, 4, 5, -6, -5, -7, -4, -8, -3, -9, -2, 0, -1 };

	public static void main(String[] args) {

		
		new BubbleSort(new JustPractice().arr);
		new SelectionSort(new JustPractice().arr);

	}
}
//----------------------------------Sorting Algorithms------------------------------------

class SortingAlgorithm{
	
}

class BubbleSort extends Helper {
	public BubbleSort(int[] arr) {
		arr = initializeArray(arr);
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swapEmelemts(arr, j, j + 1);
				}
			}
		}
		printArray(arr);
	}
}

class SelectionSort extends Helper {
	public SelectionSort(int[] arr) {
		arr = initializeArray(arr);
		printArray(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swapEmelemts(arr, i, min);
		}
		printArray(arr);
	}
}

//----------------------------------Helper Class------------------------------------

class Helper {
	static int[] initializeArray(int[] arr) {
		if (arr.length == 0) {

			Random r = new Random();

			for (int i = 0; i < arr.length; i++) {
				arr[i] = r.nextInt(100);
			}
		}
		return arr;
	}

//	--------------------------------------------------
	static void swapEmelemts(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
	}

//	--------------------------------------------------
	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}