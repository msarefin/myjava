package sortingAlgorithms;

import java.util.Random;

public class InsertionSort {

	private static int arr[];
	private static int size = 10; 
	private static int bound = 100; 
	
	
	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound); 
		displayArray(arr);
	}
	
	private static int [] initializeArray(int [] arr, int size, int bound) {
		
		arr= new int[size]; 
		
		for(int i= 0; i<size; i++) {
			arr[i]=new Random().nextInt(bound);
		}
		
		return arr; 
	}
	
	
	private static void displayArray(int [] arr) {
		for(int i = 0;i<arr.length;i++) {
			
			System.out.print(arr[i]+" ");
		}
	}
	
	
	private static void insetionSort(int [] arr) {
		
		for(int i= 1; i<arr.length; i++) {
			
		}
		
	}
	
	
}
