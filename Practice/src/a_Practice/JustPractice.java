package a_Practice;

import java.util.Arrays;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {

		printArray(a);
		sort(a, 0, a.length - 1);
		printArray(a);

	}

	static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotindex = new Random().nextInt((high - low) + 1) + low;
			swap(arr, pivotindex, high);
			int pointer = low; 
			for(int i = pointer; i< high; i++) { 
				if(arr[i]< arr[high]) {
					swap(arr, i, pointer++);
				}
			}
			swap(arr, high, pointer);
			sort(arr, low, pointer-1);
			sort(arr, pointer+1, high);
		}
	}

//------------------------------------------------------------
	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	static void swap(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
//		System.out.println("swap index :" + m + "-->" + n + "::" + arr[m] + "-->" + arr[n]);
	}

}
