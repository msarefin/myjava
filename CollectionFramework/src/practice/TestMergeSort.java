package practice;

import java.util.Random;

public class TestMergeSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	public static void main(String[] args) {
		arr = initialize(arr, size, bound);
		displayArray(arr);
	}

	private static int[] initialize(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = new Random().nextInt(bound);
		}

		return arr;
	}

	private static void displayArray(int arr[]) {
		for (int n : arr) {
			System.out.println(n + " ");
		}
	}

	
	
}