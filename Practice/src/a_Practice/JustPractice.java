package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {
		a = null; 
		int[] arr = InitializeArray(a);
		printArray(arr);
		sort(arr);
//		heapify(a, a.length, 0);
		printArray(arr);

	}

	final private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		printArray(arr);
		for (int i = n - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	final private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

//------------------------------------------------------------

	private static double sqrt(double n) {
		double t = 0;
		double sq = n / 2;
		do {
			t = sq;
			sq = (t + (n / t)) / 2;
		} while ((t - sq) != 0);
		return sq;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void swap(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
//		System.out.println("swap index :" + m + "-->" + n + "::" + arr[m] + "-->" + arr[n]);
	}

	final private static int[] InitializeArray(int[] arr) {
		int[] a;
		if (arr == null || arr.length == 0) {
			a = new int[10];
			Random r = new Random();
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(100);
			}
		} else {
			a = new int[arr.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = arr[i];
			}
		}
		return a;
	}
}