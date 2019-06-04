package sortingAlgorithms;

import java.util.Random;

public class BubbleSort {

	static int ar[];

	public BubbleSort(int arr[]) {

		int attempt = 0; 
		
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = 0; j< arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int  temp = arr[j]; 
					arr[j] = arr[j+1]; 
					arr[j+1] = temp; 
					
					attempt++; 
					System.out.print(attempt+" : ");
					printArray(arr);
				}
			}
		}
		
	}

	static int[] randomValues(int size, int range, int[] arr) {

		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(range);
		}

		return arr;
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}
	
	public static void main(String[] args) {
		ar = randomValues(10, 50, ar); 
		
		printArray(ar);
		
		new BubbleSort(ar); 
		
		printArray(ar);
	}

}
