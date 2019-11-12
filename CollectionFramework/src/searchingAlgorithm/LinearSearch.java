package searchingAlgorithm;

import java.util.Random;

public class LinearSearch {

	static int[] arr = new int[20];

	public static void main(String[] args) {
		arr(arr, 100);
		sort(arr);

//		for (int n : arr) {
//			System.out.println(n);
//		}
		
		linearSearch(arr, 45);

	}

	static int[] arr(int[] arr, int range) {
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {

			int n = r.nextInt(range);
			if (arr[i] != n) {
				arr[i] = n;
			}

		}

		return arr;
	}

	static int[] sort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr;
	}

	static void linearSearch(int [] arr, int num) {
		for(int i = 0; i<arr.length; i++) {
			while(arr[i]== num) {
				System.out.println("number found at index: "+i);
				break; 
			}
		}
		System.out.println("Search end!");
	}

}
