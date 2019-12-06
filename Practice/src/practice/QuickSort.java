package practice;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	static int arr[];
	static int size = 11;
	static int bound = 100;

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 1, 6, 2, 7, 3, 8, 4, 9, -5, -1, -6, -2, -7, -3, -8, -4, -9, 0 };
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}

	static void quickSort(int[] arr) {
//		If the array has no elements or has only one elements the sorting algorithms has no need to run.
		if (arr == null || arr.length <=1) {
			return;
		}
		partitioning(arr, 0, arr.length - 1);
	}

	static void partitioning(int[] arr, int low, int high) {
//		If the lower index is greater than the higher index the indexes are on the side
//		If the lower index is equal to the the higher index the element is already in the correct position or the array is already sorted
		if (low >= high) {
			return;
		}
//		Determine the pivote index and the pivot element
		int pi = low + (high - low) / 2;
		int pivot = arr[pi];
//		Swap the swap the pivot element in array with the last element in the array
		swap(arr, pi, high);
//		Set up a pointer index. 
		int pointerIndex = low - 1;
//		Iterate through the array using for loop before the last element
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
//				If the element in the iterative index is smaller than the pivot element, increase pointer index by 1. At this point the iterative index and the pointer index are equal.
//				if the element in the iterative index is bigger than the pivot element, the pointer index remains unchanged. At this point the pointer index is lower than the iterative index.  
//				In the next iteration if the the element in the iterative index is lower than the pivot element, then the pointer index increases by 1. At this point the pointer index points to the element that is larger than the pivot element. 
				pointerIndex++;
//				During the iteration if the pointer index is lower than the iterative index the element a the pointer index is swapped with the element at the iterative index. 
				if (pointerIndex < j) {
					swap(arr, pointerIndex, j);
				}

			}
		}
//		The new pivot index position is set to the next index after the pointer index. 
		pi = pointerIndex + 1;
//		The pivot element that was placed at the higher index is swapped with the element at the new pivot index position
		swap(arr, pi, high);
//		Once the pivot element is placed at the new pivot index position, the pivot element is considered to be at the correct position. 
//		Elements to the left of the pivot are left partition
//		Elements to the right of the pivot are right partition
		
//		The method is repeated recursively for the left partition 
		partitioning(arr, low, pi - 1);
//		The method is repeated recursively for the right partition
		partitioning(arr, pi + 1, high);
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] initializeArray(int[] arr, int size, int bound) {
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}

	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
