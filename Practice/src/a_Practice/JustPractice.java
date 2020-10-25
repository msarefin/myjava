package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {

		printArray(a);
		sort(a); 																																																																																																												
		printArray(a);

	}

	static void sort(int[] arr, int low, int high) {
		
	}

	final private static void heapify(int [] arr, int n, int i) {
		
	}
	
	private static void sort(int[] arr) {
		int n = arr.length; 
		for( int gap = n/2; gap >0; gap/=2) {
			for(int i = gap; i<n; i++) {
				int t = arr[i]; 
				int j = i; 
				while(j>=gap && arr[j-gap]>t) { 
					arr[j] = arr[j-gap]; 
					j-=gap;
				}
				arr[j]= t;
			}
		}
	}

//------------------------------------------------------------

	private static double sqrt(double n) {
		double t = 0;
		double sq = n / 2;
		do {
			t = sq;
			sq = (t + (n / t)) / 2;
		} while ((t - sq) != 0);
		return sq;
	}

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
