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

//		Determine the number of elements
		for (int n : arr) {
			if (n < 0) {
				neg++;
			} else {
				pos++;
			}
		}

//		Determin the number of buckets
		int nb = (int) squareRoot(neg);
		int pb = (int) squareRoot(pos);

//		Declare the Buckets
		List[] negativeBuckets = new List[nb];
		List[] positiveBuckets = new List[pb];

//		Initialize the buckets
		for (int i = 0; i < negativeBuckets.length; i++) {
			negativeBuckets[i] = new ArrayList();
		}
		for (int i = 0; i < positiveBuckets.length; i++) {
			positiveBuckets[i] = new ArrayList();
		}

//		Determine the max and the min 
		int max = 0;
		int min = 0;

		for(int n: arr) {
			if(n<min) {
				min = n; 
			}else if(n>max) {
				max = n; 
				
			}
		}
		
//		Put elements in the buckets
		for(int n : arr) {
			int bi = 0; 
			if(n<0) {
				bi = (n*nb)/(min-1); 
				negativeBuckets[bi].add(n);
			}else {
				bi = (n*pb)/(max+1); 
				positiveBuckets[bi].add(n);
			}
		}
		
		
//		Sort the Bucket 
		for(List nbkt: negativeBuckets) {
			for(int i = 1; i< nbkt.size(); i++) {
				int t = (int) nbkt.get(i); 
				int j = i-1;
				while(j>=0 && (int)nbkt.get(j)>t) {
					nbkt.set(j+1, nbkt.get(j));
					j--;
				}
				nbkt.set(j+1, t); 
			}
			
		}
		
		
		for(List pbkt: positiveBuckets) {
			for(int i =1; i< pbkt.size(); i++) {
				int t = (int)pbkt.get(i); 
				int j = i-1; 
				while(j>=0 && (int)pbkt.get(j)>t) {
					pbkt.set(j+1, pbkt.get(j)); 
					j--; 
				}
				pbkt.set(j+1, t); 
			}
		}
		
//		replace elements in the array 
		int index = 0; 
		for(int i = negativeBuckets.length-1; i>=0; i--) {
			for(int j = 0; j< negativeBuckets[i].size(); j++) {
				arr[index++] = (int)negativeBuckets[i].get(j);
			}
		}
		
		for(int i = 0; i< positiveBuckets.length; i++) { 
			for(int j = 0; j< positiveBuckets[i].size(); j++) {
				arr[index++] = (int)positiveBuckets[i].get(j); 
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
