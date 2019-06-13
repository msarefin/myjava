package sortingAlgorithms;

import java.util.Random;

public class MergeSort {

	private static int arr[];
	private static int size = 11, bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		displayArray(arr);

		sort(arr, 0, arr.length - 1);
		displayArray(arr);

	}

	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;

	}

	private static void displayArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	static void merge(int arr[], int first, int mid, int last) {
		int n1 = mid - first + 1;
		int n2 = last - mid;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[first + i];

		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

//		-------------------sort and Merge----------------------------

		int i = 0, j = 0;

		int k = first;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;

			} else {
				arr[k] = R[j];
				j++;

			}
			k++;
		}

//		-----------------copy Remaining values to the array----------------------------------
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	

	static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);

			displayArray(arr);

		}

	}

}
