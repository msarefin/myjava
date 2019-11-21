package practice;

public class MergeSort {
	
	/*
	 * I am just practicing Merge sort
	 */

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 1, 7, 3, 6, 4, 8, 2, 5, 0, -1, -2, -3 };

		printArray(arr);
		mergeSort(arr);

	}

	static void mergeSort(int[] arr) {
		if (arr == null) {
			return;
		}

		if (arr.length > 1) {
			int mid = arr.length / 2;

			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];

			for (int i = 0; i < arr.length; i++) {
				if (i < mid) {
					left[i] = arr[i];
				} else {
					right[i - mid] = arr[i];
				}
			}

			System.out.println("left");
			printArray(left);
			System.out.println("right");
			printArray(right);
			mergeSort(left);
			mergeSort(right);

			int i = 0, j = 0, k = 0;

			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					arr[k++] = left[i++];
				} else {
					arr[k++] = right[j++];
				}
			}

			while (i < left.length) {
				arr[k++] = left[i++];
			}
			while (j < right.length) {
				arr[k++] = right[j++];
			}

		}
		printArray(arr);
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
