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
		if (arr == null || arr.length<=1)
			return; // if the array in empty or the length of the array is less than or equal to 1, then simply return

		if (arr.length > 1) { // if there are more than one element in the array 
			int mid = arr.length / 2; // Divide the array 
			int left[] = new int[mid]; // Create the left array
			int right[] = new int[arr.length - mid]; // Create the right array

			for (int i = 0; i < left.length; i++) {
				left[i] = arr[i]; // fill in the left array
			}

			for (int i = 0; i < right.length; i++) {
				right[i] = arr[mid + i]; // Fill in the right array
			}

			mergeSort(left); // recursively run the mergeSort method to further divide the array until there is only one element in the array
			mergeSort(right); // recursively run the mergeSort method to further divide the array until there is only one element in the array

			int l = 0, r = 0, k = 0;

			while (l < left.length && r < right.length) {
				if (left[l] < right[r]) { //compare elements of the left array and the right array 
					arr[k++] = left[l++]; // Copy the smallest element into the original array
				} else {
					arr[k++] = right[r++];
				}
			}

//			Copy the remaining elements of the left or the right array into the next index position of the original array
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
