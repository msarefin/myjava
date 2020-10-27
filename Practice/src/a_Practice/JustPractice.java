package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {
//		a = null;
		int[] arr = InitializeArray(a);
		printArray(arr);
		sort(arr);
		printArray(arr);

	}

	final static void sort(int[] arr) {
		int n = arr.length - 1;
		for (int p = n / 2; p >= 0; p--) {
			heapify(arr, n, p);
		}
		for (int i = n; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	final static void heapify(int[] arr, int n, int i) {
		int h = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l <= n && arr[l] > arr[h]) {
			h = l;
		}
		if (r <= n && arr[r] > arr[h]) {
			h = r;
		}
		if (h != i) {
			swap(arr, i, h);
			heapify(arr, n, h);
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
			a = new int[100];
			Random r = new Random();
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(1000);
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