package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class BucketSort {

	private static int arr[];
	private static int size = 10;
	private static int bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		displayArray(arr);
		sort(arr, size);
		displayArray(arr);
	}

	private static int[] initializeArray(int arr[], int size, int bound) {
		arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(bound);
		}
		return arr;
	}

	private static void displayArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int arr[], int size) {
		int bsize = (int)Math.sqrt(size); 
		int bucket[] = new int[bsize];
		
		for(int i = 0 ; i<bucket.length; i++) {
			bucket[i] = 0; 
		}
		
		for(int i =0 ; i<arr.length; i++) {
			bucket[arr[i]]++; 
		}
		
		int outPos= 0; 
		for(int i = 0; i<bucket.length; i++) {
			for(int j = 0; j<bucket[i]; j++) {
				arr[outPos++] = i; 
			}
		}
		
		
	}
}
