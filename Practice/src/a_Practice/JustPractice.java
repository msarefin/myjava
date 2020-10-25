package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {

		printArray(a);
		sort(a);
		printArray(a);

	}

	final private static void heapify(int[] arr, int high, int low) {
		int largest = low;
		int l = 2 * low + 1;
		int r = 2 * low + 2;

		if (l < high && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < high && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != low) {
			swap(arr, low, largest);
			heapify(arr, high, largest);
		}
	}
	
	final private static void sort(int [] arr) {
		int n = arr.length; 
		for(int j = n/2-1; j>=0; j--) {
			heapify(arr, n, j);
		}
		
		for(int i = n -1; i>=0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
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

}
