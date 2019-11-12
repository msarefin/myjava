package Practicing;

public class practice {

	final static int[] arr = new int[] { 5, 6, 4, 8, 2, 3, 1, 7, 9, 0 };

	public static void main(String[] args) {
		practice p = new practice();
		int[] bubbleSort = ar(arr);
		bubbleSort(bubbleSort);

		int[] selectionSort = ar(arr);
		selectionSort(selectionSort);

		
	}

	// ---------------------------------------------sorting
	// algorithms-------------------------------

	public static void bubbleSort(int[] arr) {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println(methodName);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				int f = j, l = j + 1;
				if (arr[f] > arr[l]) {
					swap(arr, f, l);

				}
			}
		}
		printArray(arr);
	}

	static void selectionSort(int[] arr) {
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		System.out.println(methodName);
		for (int i = 0; i < arr.length - 1; i++) {
			int p = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[p]) {
					p = j;
				}
			}

			swap(arr, i, p);
		}
		printArray(arr);
	}

	// ----------------------------------------------------------------------------

	static int[] ar(int[] arr) {
		int a[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[i] = arr[i];
		}
		printArray(a);

		return a;

	}

	static void swap(int[] arr, int f, int l) {
		int t = arr[f];
		arr[f] = arr[l];
		arr[l] = t;
	}

	static void printArray(int[] arr) {
		for (int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

}
