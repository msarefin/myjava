package practice;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 8, 3, 1, 6, 4, 9, 7, 0, -5, -2, -1, 10, -3, -8, -7 };
		displayArray(arr);
		heapSort(arr);
		displayArray(arr);
	}
	
	static void heapSort(int [] arr) {
		int n = arr.length; 
		for(int i = n/2-1; i>=0; i--) {
			heapify(arr, n, i);
		}
		for(int i = n-1; i>=0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	static void heapify(int [] arr, int n , int i) {
		int largest = i; 
		int left = 2*i+1; 
		int right = 2*i+2; 
		
		if (left<n && arr[left]> arr[largest]) {
			largest = left;  
		}
		
		if(right< n && arr[right]>arr[largest]) {
			largest = right; 
		}
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
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
