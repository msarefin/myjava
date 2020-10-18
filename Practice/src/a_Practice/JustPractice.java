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
			printArray(arr);
			int p = partition(arr, low, high);
			System.out.println(p);
			sort(arr, low, p - 1);
			sort(arr, p + 1, high);
		}
	}

	static int partition(int[] arr, int low, int high) {
		swap(arr, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (arr[i] < arr[low]) {
				swap(arr, i, border++);
			}
		}
		swap(arr, low, border - 1);
		return border - 1;
	}

	static int getPivot(int low, int high) {
		return new Random().nextInt((high - low) + 1) + low;
	}

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
