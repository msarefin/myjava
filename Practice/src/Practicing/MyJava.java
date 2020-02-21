package Practicing;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import practice.QuickSort;
import practice.Quick_sort;

public class MyJava {

	final private int[] arr = new int[] { 3, 7, 1, 9, 6, 4, 8, 2, 5, 0, -2, -5, -1, -3 };

	public static void main(String[] args) {

		System.out.println(System.getProperty("java.version"));

		String[] algorithmName = { "bubbleSort", "selectionSort", "insertionSort", "bucketSort", "heapSort",
				"shellSort", "mergeSort", "quickSort" };

		MyJava[] algorithmsArray = new MyJava[algorithmName.length];

		for (int i = 0; i < algorithmsArray.length; i++) {
			algorithmsArray[i] = new MyJava();
		}

		for (int i = 0; i < algorithmName.length; i++) {
			sortingAlgorithm(algorithmsArray[i].arr, algorithmName[i]);
		}

	}

	private static void sortingAlgorithm(int[] arr, String algorithm) {

		switch (algorithm) {
		case "bubbleSort":
			bubbleSort(arr);
			break;

		case "selectionSort":
			selectionSort(arr);
			break;

		case "insertionSort":
			insertionSort(arr);
			break;

		case "bucketSort":
			bucketSort(arr);
			break;

		case "heapSort":
			heapSort(arr);
			break;

		case "shellSort":
			shellSort(arr);
			break;

		case "mergeSort":
			mergeSort(arr);
			break;

		case "quickSort":
			quickSort(arr);
			break;

		default:
			System.out.println("Please Select correct Sorting Algorithm");
			break;
		}

		printArray(arr);
		System.out.println();

	}

//	-------------------------------------------Bubble Sort------------------------------------------------------
	private static void bubbleSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

//	-------------------------------------------Selection Sort------------------------------------------------------

	private static void selectionSort(int[] arr) {
		getMethodName(1);
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

	}

//	-------------------------------------------Insertion Sort------------------------------------------------------

	private static void insertionSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > t) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}

	}
//	-------------------------------------------Bucket Sort------------------------------------------------------

	private static void bucketSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

		int neg = 0;
		int pos = 0;

		for (int n : arr) {
			if (n < 0) {
				neg++;
			} else {
				pos++;
			}
		}

		int nb = (int) Math.sqrt(neg);
		int pb = (int) Math.sqrt(pos);

		List[] negativeBucket = new List[nb];
		List[] positiveBucket = new List[pb];

		for (int i = 0; i < negativeBucket.length; i++) {
			negativeBucket[i] = new ArrayList();
		}
		for (int i = 0; i < positiveBucket.length; i++) {
			positiveBucket[i] = new ArrayList();
		}

		int min = 0;
		int max = 0;

		for (int n : arr) {
			if (min > n) {
				min = n;
			} else if (max < n) {
				max = n;
			}
		}

		for (int n : arr) {
			int bi = 0;
			if (n < 0) {
				bi = (n * nb) / (min - 1);
				negativeBucket[bi].add(n);
			} else {
				bi = (n * pb) / (max + 1);
				positiveBucket[bi].add(n);
			}
		}

		for(List nbkt: negativeBucket) {
			for(int i = 1; i<nbkt.size();i++) {
				int t = (int) nbkt.get(i);
				int j = i-1; 
				while(j>=0 && (int)nbkt.get(j)>t) {
					if((int)nbkt.get(j)>t) {
						nbkt.set(j+1, nbkt.get(j));
						j--;
					}
					nbkt.set(j+1, t);
				}
			}
		}
		for(List pbkt: positiveBucket) {
			for(int i = 1; i<pbkt.size(); i++) {
				int t = (int) pbkt.get(i); 
				int j = i-1; 
				while(j>=0 && (int)pbkt.get(j)>t) {
					if((int)pbkt.get(j)>t) {
						pbkt.set(j+1, pbkt.get(j));
						j--;
					}
					pbkt.set(j+1, t); 
				}
			}
		}

		System.out.println(Arrays.toString(negativeBucket));
		System.out.println(Arrays.toString(positiveBucket));

		
		int index = 0; 
		
		for(int i =negativeBucket.length-1; i>=0; i--) {
			for(int j = 0; j<negativeBucket[i].size(); j++) {
				arr[index++] = (int)negativeBucket[i].get(j);
			}
		}
		for(int i = 0; i<positiveBucket.length; i++) {
			for(int j =0; j<positiveBucket[i].size();j++) {
				arr[index++] = (int)positiveBucket[i].get(j);
			}
		}
		
	}
//	-------------------------------------------Heap Sort------------------------------------------------------

	private static void heapSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

	}
//	-------------------------------------------Shell Sort------------------------------------------------------

	private static void shellSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

	}
//	-------------------------------------------Merge Sort------------------------------------------------------

	private static void mergeSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

	}
//	-------------------------------------------Quick Sort------------------------------------------------------

	private static void quickSort(int[] arr) {
		getMethodName(1);
		printArray(arr);

	}
//	-------------------------------------------Helper Methods------------------------------------------------------

	private static void getMethodName(int type) {
		String methodName = "";
		String[] m;

		switch (type) {
		case 1:
			m = new Throwable().getStackTrace()[1].getMethodName().split("(?=[A-Z])");
			for (String n : m) {
				methodName = methodName + n.substring(0, 1).toUpperCase() + n.substring(1) + " ";
			}
			break;

		case 2:
			m = new Exception().getStackTrace()[1].getMethodName().split("(?=[A-Z])");
			for (String n : m) {
				methodName = methodName + n.substring(0, 1).toUpperCase() + n.substring(1) + " ";
			}
			break;
		case 3:
			m = new Object() {
			}.getClass().getMethods()[1].getName().toString().split("(?=[A-Z])");
			for (String n : m) {
				methodName = methodName + n.substring(0, 1).toUpperCase() + n.substring(1) + " ";
			}
			break;
		case 4:
			m = Thread.currentThread().getStackTrace()[2].getMethodName().split("(?=[A-Z])");
			for (String n : m) {
				methodName = methodName + n.substring(0, 1).toUpperCase() + n.substring(1) + " ";
			}
			break;

		default:
			methodName = "Unknown Method";
			break;
		}

		methodName = methodName.trim();
		System.out.println(methodName + "\n" + "=".repeat(methodName.length()));

	}

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
