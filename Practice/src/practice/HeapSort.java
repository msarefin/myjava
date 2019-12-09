package practice;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 8, 3, 1, 6, 4, 9, 7, 0, 10, -4, -6, -7, -8 };
		displayArray(arr);
		heapSort(arr);
		displayArray(arr);
	}

	static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) { // i is the parent node index of the last child node. 
			heapify(arr, n, i); // run the heapify method to convert the the array into a max heap
		}
		for (int i = n - 1; i >= 0; i--) { // go through the array in reverse order
			swap(arr, 0, i); // swap the first element of the array with the last element the loop the loop is pointing to. At this point the last element is no longer part of the heap and in the array it is already sorted in the last position
			heapify(arr, i, 0); // Heapify the array top down
		}
	}

	static void heapify(int[] arr, int n, int li) {
		int largest = li; // setting a pointer of the highest value assuming the parent node hold the highest value
		int left = 2 * li + 1; // index of the left node 
		int right = 2 * li + 2; // index of the right node

		if (left < n && arr[left] > arr[largest]) { // making sure the left child index is within the boundary of the array size, && checking if the element at the left child index is greater than the element of the parent node. 
			largest = left; // if the left child is greater than the parent, set the pointer index of the highest value to the left index.
		}

		if (right < n && arr[right] > arr[largest]) { // making sure the right child index index is within the boundary of the array size, && checking if the element at the right child index is greater than the element of the parent node. 
			largest = right; // if the right child  is greater than the parent, set the pointer index of the highest value to the right index
		}
		if (largest != li) { // if the pointer index to the highest value is not equal to the parent node index
			swap(arr, li, largest); // swap the elements
			heapify(arr, n, largest); // considering the pointer index to the highest value as the parent index, recursively run the heapify method to the lower child if any. 
		}

	}

	static void displayArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
