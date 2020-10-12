package a_Practice;

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithmPractice {

	public static void main(String[] args) {
		int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };
		sortingMethods s = new sortingMethods();
		s.bubbleSort(a);
		s.SelectionSort(a);
		s.InsertionSort(a);
	}

}

class sortingMethods extends HelperMethods {
	void bubbleSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					SwapElements(arr, j, j + 1);
				}
			}
		}
		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(a).length()));
	}

	void SelectionSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			int m = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[m]) {
					m = j;
				}
			}
			SwapElements(arr, m, i);
		}

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}

	void InsertionSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > t) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}
}

class HelperMethods {

	static int[] InitializeArray(int[] arr) {
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

	static void getMethodName() {
		String n[] = new Throwable().getStackTrace()[1].getMethodName().split("(?=[A-Z])");
		String msg = "";
		for (String x : n) {
			msg = msg + x + " ";
		}
		msg = msg.trim();

		System.out.println(msg + "\n" + "=".repeat(msg.length()));

	}

	static void SwapElements(int[] a, int m, int n) {
		int t = a[m];
		a[m] = a[n];
		a[n] = t;
	}

	static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
}
