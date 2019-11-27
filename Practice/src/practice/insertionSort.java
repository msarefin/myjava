package practice;

public class insertionSort {
	static int[] arr = new int[] { 9, 3, 7, 1, 6, 4, 8, 2, 5, 0, -1, -2, -3 };

	public static void main(String[] args) {
		InsertionSort(arr);
		printArray(arr);
	}

	static void InsertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i-1; 
			printArray(arr);
			while(j>=0 && arr[j]>t) {
				arr[j+1] = arr[j]; 
				j--; 
			}
			arr[j+1] = t; 
		}
	}

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
