package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.sun.tools.classfile.TypeAnnotation.Position;

public class SortingAlgorithmPractice {

	public static void main(String[] args) {
		int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };
		sortingMethods s = new sortingMethods();
		s.BubbleSort(a);
		s.SelectionSort(a);
		s.InsertionSort(a);
		s.BucketSort(a);
	}

}

class sortingMethods extends HelperMethods {
	void BubbleSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					SwapElements(arr, j, j + 1);
				}
			}
		}
		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(a).length()));
	}

	void SelectionSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			int m = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[m]) {
					m = j;
				}
			}
			SwapElements(arr, m, i);
		}

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}

	void InsertionSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
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

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}

	void BucketSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		int pos = 0;
		int neg = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				neg++;
			} else {
				pos++;
			}
		}

		int nb = (int) sqrt(neg);
		int pb = (int) sqrt(pos);

		List[] nBucket = new List[nb];
		List[] pBucket = new List[pb];

		for (int i = 0; i < nBucket.length; i++) {
			nBucket[i] = new ArrayList();
		}
		for (int i = 0; i < pBucket.length; i++) {
			pBucket[i] = new ArrayList();
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
				bi = (n*nb)/(min-1); 
				nBucket[bi].add(n); 
			}else {
				bi = (n*pb)/(max+1);
				pBucket[bi].add(n); 
			}
		}
		
		for(List n: nBucket) {
			for(int i = 1; i<n.size(); i++) {
				
			}
		}

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}
}

class HelperMethods {

	static double squareRoot(int number) {
		double temp;
		double sr = number / 2;
		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);
		return sr;
	}

	static double sqrt(int n) {
		double t;
		double sq = n / 2;
		do {
			t = sq;
			sq = (t + (n / t)) / 2;
		} while ((t - sq) != 0);
		return sq;
	}

	static int[] InitializeArray(int[] arr) {
		int[] a;
		if (arr == null || arr.length == 0) {
			a = new int[10];
			Random r = new Random();
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(100);
			}
		} else {
			a = new int[arr.length];
			for (int i = 0; i < a.length; i++) {
				a[i] = arr[i];
			}
		}
		return a;
	}

	static void getMethodName() {
		String n[] = new Throwable().getStackTrace()[1].getMethodName().split("(?=[A-Z])");
		String msg = "";
		for (String x : n) {
			msg = msg + x + " ";
		}
		msg = msg.trim();

		System.out.println(msg + "\n" + "=".repeat(msg.length()));

	}

	static void SwapElements(int[] a, int m, int n) {
		int t = a[m];
		a[m] = a[n];
		a[n] = t;
	}

	static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
}
