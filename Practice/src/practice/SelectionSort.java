package practice;

public class SelectionSort {
	static int[] arr = new int[] { 9, 3, 7, 1, 6, 4, 8, 2, 5, 0, -1, -2, -3 };

	public static void main(String[] args) {
		printArray(arr);
		selectionSort(arr);
		printArray(arr);
	}

	static void selectionSort(int [] arr){
		for (int i = 0; i < arr.length-1; i++) {
			int p = i; 
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j]<arr[p]) {
					p = j; 
				}
			}
			swap(arr, i, p);
		}
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void swap(int[] arr, int n, int m) {
		int t = arr[n];
		arr[n] = arr[m];
		arr[m] = t;
	}

}
