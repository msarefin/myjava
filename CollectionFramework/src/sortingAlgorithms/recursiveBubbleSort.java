package sortingAlgorithms;

import java.util.Random;

public class recursiveBubbleSort {

	private static int arr[];
	private static int size = 10; 
	private static int bound = 100; 

	public static void main(String[] args) {

		arr = initializeArray(arr, size, bound);
		displayArray(arr);
		rBubbleSort(arr,size);
		displayArray(arr);

	}

	private static int[] initializeArray(int arr[], int size, int bound) {

		arr = new int[size];
		for (int i = 0; i < size; i++) {

			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}
	
	
	private static void displayArray(int arr[]) {
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
	}

	
	private static void rBubbleSort(int arr [], int size) {
		
		if(size == 1) return; 
		
		for(int i = 0; i<size-1; i++) {
			if(arr[i]>arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1]; 
				arr[i+1] = temp; 
			}
			
		}
		rBubbleSort(arr, size-1);
		
	}
	
}
