package practice;

public class MergeSort {

	/*
	 * I am just practicing Merge sort
	 */

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 1, 7, 3, 6, 4, 8, 2, 5, 0, -1, -2, -3 };

		printArray(arr);
		mergeSort(arr);
		printArray(arr);

	}

	static void mergeSort(int[] arr) {
		if (arr == null)
			return;

		if (arr.length > 1) {
			int mid = arr.length / 2;

			int left[] = new int[mid];
			int right[] = new int[arr.length - mid];

			for (int i = 0; i < left.length; i++) {
				left[i] = arr[i];
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = arr[mid + i];
			}

			mergeSort(left);
			mergeSort(right);

			int l = 0, r = 0, k = 0;

			while (l < left.length && r < right.length) {
				if (left[l] < right[r]) {
					arr[k++] = left[l++];
				} else {
					arr[k++] = right[r++];
				}
			}

			while (l < left.length) {
				arr[k++] = left[l++];
			}
			while (r < right.length) {
				arr[k++] = right[r++];

			}

		}
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
