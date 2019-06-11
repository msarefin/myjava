package sortingAlgorithms;

import java.util.Random;

import javax.naming.InitialContext;

public class InsertionSort {

	private static int arr[];

	static int[] initialization(int[] arr, int size, int bound) {

		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);

		}

		return arr;
	}
	
	private static void displayArray(int [] arr) {
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

	public static void main(String[] args) {

		arr = initialization(arr);

	}
}
