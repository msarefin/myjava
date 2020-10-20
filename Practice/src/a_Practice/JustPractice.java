package a_Practice;

import java.util.Arrays;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {

		printArray(a);
		sort(a, 0, a.length - 1);
		printArray(a);

	}

	static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = new Random().nextInt((high-low)+1)+low;
			pivotIndex = low; 
			int b = low - 1;

			for (int i = low; i < high; i++) {
				if (arr[i] < arr[b]) {
					b++; 
					swap(arr, b , i);
					printArray(arr);
				}
			}
			swap(arr, b+1, high);
			System.out.println(b);
			printArray(arr);
			int pi = b+1; 
			sort(arr, low , pi-1);
			sort(arr, pi+1, high);
		}
	}

//	private static int partition(int[] arr, int low, int high) {
//		int pivot = arr[high];
//		int i = (low - 1);
//
//		for (int j = low; j < high; j++) {
//			if (arr[j] <= pivot) {
//				i++;
//				swap(arr, i, j);
//			}
//		}
//		swap(arr, i + 1, high);
//		return i + 1;
//	}

//------------------------------------------------------------
	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void swap(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
	}

}
