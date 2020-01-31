package Practicing;

import java.util.Arrays;
import java.util.Random;

public class MyJava {

//	private int[] arr = new int[] { 3, 7, 1, 9, 6, 4, 8, 2, 5, 0, -2, -5, -1, -3 };
	private int[] ar;
	
	public static void main(String[] args) {

		MyJava bubbleSort = new MyJava(); 
		bubbleSort.ar = initialize(bubbleSort.ar, 10, 100);
		printArray(bubbleSort.ar);
		bubbleSort(bubbleSort.ar);
		
	}
	
	private static void bubbleSort(int [] arr) {
		String method = new Throwable().getStackTrace()[0].getMethodName(); 
		System.out.println(method.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])","(?<=[^A-Z])(?=[A-Z])","(?<=[A-Za-z])(?=[A-Z][^A-Za-z])")," "));
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
