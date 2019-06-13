package practice;

import java.util.Random;

public class TestMergeSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	private static int temp[];

	public static void main(String[] args) {
		arr = initialize(arr, size, bound);
		temp = new int[size];
		displayArray(arr);
		
		sort(arr, 0	, arr.length);
		displayArray(arr);
		
	}

	private static int[] initialize(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}

	private static void displayArray(int arr[]) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static void sort(int arr[], int l, int r) {

		if (l != r) {
			int m = l+(r - l) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	private static void merge(int arr[], int l, int m, int r) {

		for(int i = 0; i<arr.length; i++) {
			temp[i] = arr[i]; 
		}
		
		
		int n1 = l;
		int n2 = m + 1;
		int index = l;

		while (n1 < m && n2 < r) {

			if (temp[n1] >= temp[n2]) {
				arr[index] = temp[n2];
				n2++;
			} else {
				arr[index] = temp[n1];
				n1++;
			}

			index++;
		}

		while (n1 <= m) {
			arr[index] = temp[n1];
			index++; 
			n1++; 
		}

	}

}