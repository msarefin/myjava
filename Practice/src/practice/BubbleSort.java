package practice;

public class BubbleSort {
	static int[] arr = new int[] { 9, 3, 7, 1, 6, 4, 8, 2, 5, 0, -1, -2, -3 };

	public static void main(String[] args) {
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}

	static void bubbleSort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static void swap(int [] arr, int n , int m) {
		int t = arr[n]; 
		arr[n] = arr[m]; 
		arr[m] = t; 
	}

}
