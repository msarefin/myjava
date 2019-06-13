package practice;

import java.util.Random;

public class Test {
	private static int arr [] = {82, 65, 97, 20, 71, 79, 74, 9, 1, 65, 68 };
	private static int size = 11;
	private static int bound = 100;

	public static void main(String[] args) {

//		arr = initializeArray(arr, size, bound);
		
		displayArray(arr);
		sort(arr, 0, arr.length - 1);
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
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	private static void sort(int[] arr, int f, int l) {

		if (f < l) {
			int m = (f + l) / 2;
			sort(arr, f, m);
			sort(arr, m + 1, l);
			merge(arr, f, m, l);
			displayArray(arr);

		}

	}

	private static void merge(int arr[], int f, int m, int l) {

		int n1 = m - f + 1;
		int n2 = l - m; // 4-2 = 2

		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = arr[i + f];
//			System.out.print("\tLeft : ");
//			displayArray(left);
		}

		
		
		for (int i = 0; i < n2; i++) {
			right[i] = arr[i + m + 1]; // 2+1 = 3
//			System.out.print("\tright  : ");
//			displayArray(right);
		}

		
		
		int i = 0, j = 0, k = f;

		while (i < n1 && j < n2) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;

			}

			k++;

		}
		
		
		while(i < n1) {
			arr[k] = left[i]; 
			i++; 
			k++; 
			
		}
		
		
		while(j < n2) {
			arr[k] = right[j]; 
			j++; 
			k++; 
		}
		
		
		
	}

}