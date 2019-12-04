package practice;

import java.util.Arrays;

public class Quick_sort {

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 1, 2, 7, 12, 3, 8, 4, 9, 5, 0, 10, -1, -3, -2 };
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

	static void quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		partition(arr, 0, arr.length - 1);
	}

	static void partition(int[] arr, int low, int high) {
		int i = low, j = high;
		int p = low + (high - low) / 2;
		int pivot = arr[high];
//		System.out.println(high+":pivot:"+pivot);
//		System.err.println("arr["+i+"]::"+arr[i]);
//		System.err.println("arr["+j+"]::"+arr[j]);
//		printArray(arr);

		while (i <= j) {
			while (arr[i] < pivot) {
				System.out.println("arr[i] < pivot: " + arr[i] + "<" + pivot);
				i++;
			}
			while (arr[j] > pivot) {
				System.out.println("arr[j] > pivot: " + arr[j] + ">" + pivot);
				j--;
			}
			if (i <= j) {
				System.out.println("Swap " + arr[i] + ":::" + arr[j]);
				swap(arr, i++, j--);
				printArray(arr);
			}
		}
		if (low < j) {
			partition(arr, low, j);
		}
		if (i < high) {
			partition(arr, i, high);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
