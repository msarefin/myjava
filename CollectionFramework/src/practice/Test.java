package practice;

import java.util.Random;

public class Test {

	private static int arr[];
	private static int size = 10, bound = 100;

	public static void main(String[] args) {
		arr = initializeArray(arr, size, bound);
		displayArray(arr);

		sort(arr, 0, arr.length-1);
		
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
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void sort(int arr[], int li, int ri) {

		if (li < ri) {
			int m = (li + ri) / 2;
			sort(arr, li, m);
			sort(arr, m + 1, ri);

			merge(arr, li, m, ri);

//			displayArray(arr);
			
		}

	}

	private static void merge(int arr[], int li, int m, int ri) {
		int n1 = m - li + 1;
		int n2 = ri - m;

		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i = 0; i <n1; i++) {
			L[i] = arr[li +i]; 
		}
		
//		System.out.print("Left : ");
//		displayArray(L);
		
		
		for(int i = 0; i < n2; i++) {
			R[i] = arr[m+1+i]; 
		}
		
//		System.out.print("Right : ");
//		displayArray(R);
		
		int i = 0 , j = 0, k = li; 
		
		while(i < n1 && j <n2) {
			if(L[i]<=R[j]) {
				arr[k] = L[i]; 
				i++; 
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k] = L[i]; 
			i++; 
			j++; 
		}
		
		while(j <n2) {
			arr[k] = R[j]; 
			j++; 
			k++; 
		}
		
		
	}
}