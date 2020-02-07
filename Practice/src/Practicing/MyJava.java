package Practicing;

import java.util.Arrays;
import java.util.Random;

public class MyJava {

	final private int[] ar = new int[] { 3, 7, 1, 9, 6, 4, 8, 2, 5, 0, -2, -5, -1, -3 };
//	private int[] ar;

	public static void main(String[] args) {

		MyJava bubbleSort = new MyJava();
		MyJava selectionSort = new MyJava();
		MyJava insertionSort = new MyJava();
		MyJava bucketSort = new MyJava();
		MyJava heapSort = new MyJava();
		MyJava shellSort = new MyJava();
		MyJava mergeSort = new MyJava();
		MyJava quickSort = new MyJava();

//		bubbleSort.ar = initialize(bubbleSort.ar, 10, 100);

		bubbleSort(bubbleSort.ar);
		selectionSort(selectionSort.ar);

	}

//	--------------------------------------------------------------------------------------------------------------------------
	private static void bubbleSort(int[] arr) {
		String method = new Throwable().getStackTrace()[0].getMethodName();
		System.out.println(method.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[A-Z][^A-Za-z])"), " "));

		printArray(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
		printArray(arr);
	}

	// ------------------------------------------------------------------------------------------------------------------------

	private static void selectionSort(int[] arr) {
		String method = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(method.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[A-Z][^A-Za-z])"), " "));

		String[] r = method.split("(?=[A-Z])");

		System.out.println(Arrays.toString(r));
		
		for(String n: r) {
			System.out.print(n.substring(0,1).toUpperCase()+n.substring(1)+" ");
		}

		System.out.println();
		printArray(arr);

		for (int i = 0; i < arr.length; i++) {
			int p = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[p]) {
					p = j;
				}
			}
			swap(arr, i, p);
		}
		printArray(arr);
	}

//	-----------------------------------------------------------------------------------------------------------------------------  

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	private static int[] initialize(int[] arr, int size, int range) {
		arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(range);
		}
		return arr;
	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
