package practice;

import java.util.Random;

import sortingAlgorithms.BubbleSort;

public class SortingAlgorithum {

	static int[] arr;

	public static void main(String[] args) {

		arr = setupArray(arr, 10, 50);
		displayArray(arr);

//		new bubbleSort(arr);
		new SelectionSort(arr);

		displayArray(arr);
		
		

	}

	static int[] setupArray(int[] arr, int size, int range) {

		arr = new int[size];

		Random r = new Random();

		for (int i = 0; i < size; i++) {
			arr[i] = r.nextInt(range);
		}

		return arr;
	}

	static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}

class bubbleSort {

	public bubbleSort(int[] arr) {
		int id = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					id++;
					System.out.print(id + " : ");
					
					for(int a = 0; a<arr.length; a++) {
						System.out.print(arr[a]+" ");
					}
					
					System.out.println();

				}
			}
			
		}

	}

}


class SelectionSort{
	
	public SelectionSort(int []arr) {
		int id = 0; 
		
		for(int i =0; i <arr.length-1;i++) {
			for(int j =i; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j]; 
					arr[j] = temp; 
					
					id++; 
					System.out.print(id+" : ");
					
					for(int a= 0; a<arr.length; a++) {
						System.out.print(arr[a]+" ");
					}
					
					System.out.println();
				}
			}
		}
	}
	
}
