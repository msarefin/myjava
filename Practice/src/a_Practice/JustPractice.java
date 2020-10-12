package a_Practice;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class JustPractice {

	static int[] arr = new int[] { 9, 1, 8, 2, 7, 3, 6, 4, 5, -6, -5, -7, -4, -8, -3, -9, -2, 0, -1 };

	public static void main(String[] args) {

		SortingAlgorithm sortingAlgorithm = new SortingAlgorithm(arr);

		sortingAlgorithm.BubbleSort(arr);
		sortingAlgorithm.SelectionSort(arr);
		sortingAlgorithm.InsertionSort(arr);

	}
}
//----------------------------------Sorting Algorithms------------------------------------

class SortingAlgorithm extends Helper implements AlgorithmList {

	int a[];

	public SortingAlgorithm(int[] arr) {
		// TODO Auto-generated constructor stub
		a = initializeArray(arr);
	}

	@Override
	public void BubbleSort(int[] arr) {
		String[] n = new Throwable().getStackTrace()[0].getMethodName().split("(?=[A-Z])");
		String msg = "";
		for (String x : n) {
			msg = msg + x + " ";
		}
		msg = msg.trim(); 
		System.out.println(msg + "\n" + "=".repeat(msg.length()));
		// TODO Auto-generated method stub
		a = initializeArray(arr);
		printArray(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					swapEmelemts(a, j, j + 1);

				}
			}
		}
		printArray(a);

	}

	@Override
	public void SelectionSort(int[] arr) {
		String[] n = new Throwable().getStackTrace()[0].getMethodName().split("(?=[A-Z])");
		String msg = "";
		for(String x:n) {
			msg = msg+x+" ";
		}
		msg = msg.trim(); 
		System.out.println(msg+"\n"+"=".repeat(msg.length()));
		a = initializeArray(arr);
		printArray(a);

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			swapEmelemts(a, min, i);
		}
		printArray(a);

	}

	@Override
	public void InsertionSort(int[] arr) {
		String n = getMethodName();
		System.out.println(n + "\n" + "*".repeat(n.length()));
		// TODO Auto-generated method stub
		a = initializeArray(arr);
		printArray(a);

		for (int i = 1; i < a.length; i++) {
			int t = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > t) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = t;
		}

		printArray(a);

	}

	@Override
	public void BucketSort(int[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MergeSort(int[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void QuickSort(int[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void HeapSort(int[] arr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ShellSort(int[] arr) {
		// TODO Auto-generated method stub

	}

}

interface AlgorithmList {
	void BubbleSort(int[] arr);

	void SelectionSort(int[] arr);

	void InsertionSort(int[] arr);

	void BucketSort(int[] arr);

	void MergeSort(int[] arr);

	void QuickSort(int[] arr);

	void HeapSort(int[] arr);

	void ShellSort(int[] arr);

}

//----------------------------------Helper Class------------------------------------

class Helper {
	static int[] initializeArray(int[] arr) {
		int[] a;
		if (arr == null || arr.length == 0) {
			a = new int[10];
			Random r = new Random();

			for (int i = 0; i < a.length; i++) {
				arr[i] = r.nextInt(100);
			}
		} else {
			a = new int[arr.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = arr[i];
			}
		}
		return a;
	}

//	--------------------------------------------------
	static void swapEmelemts(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
	}

//	--------------------------------------------------
	static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

//	--------------------------------------------------
	static void GetListOfMethods(String Methodname) {
		Method methodList[] = null;
		try {
			methodList = Class.forName(Methodname).getMethods();

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Method m : methodList) {
			System.out.println(m.getName());
		}

	}

//	--------------------------------------------------------

	static String getMethodName() {
		return new Throwable().getStackTrace()[1].getMethodName();
	}

}