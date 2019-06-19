package practice;

import java.util.Arrays;
import java.util.Random;

public class myheapSort {

	private static int arr[];
	private static int size = 15;
	private static int bound = 100;

	public static void main(String[] args) {
		arr = initailizeArray(arr, size, bound);
		displayArray(arr);
	}

	private static int[] initailizeArray(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}

	private static void displayArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort (int arr[]) {
		
		int n = arr.length; 
		for(int i = n/2-1;i >=0; i-- ) {
//			heapify
		}
		
		for(int i = n-1; i>=0 ; i--) {
			int temp = arr[0];
			arr[0] = arr[i]; 
			arr[i] = temp; 
			
//			heapify
		}
		
	}
	
}
