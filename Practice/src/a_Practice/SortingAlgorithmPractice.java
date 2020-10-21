package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingAlgorithmPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, 5, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {
//		int[] a = null; 
		sortingMethods s = new sortingMethods();
		s.BubbleSort(a);
		s.SelectionSort(a);
		s.InsertionSort(a);
		s.BucketSort(a);
		s.MergeSort(a);
		s.QuickSort(a);
		s.ShellSort(a);
		s.HeapSort(a);
		s.RedixSort(a);
	}

}

class sortingMethods extends HelperMethods implements AlgorithmList {
	public void BubbleSort(int[] a) {
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

	public void SelectionSort(int[] a) {
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

	public void InsertionSort(int[] a) {
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

	public void BucketSort(int[] a) {
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		int pos = 0;
		int neg = 0;

		for (int n : arr) {
			if (n < 0) {
				neg++;
			} else {
				pos++;
			}
		}

		List[] nBucket = null;
		List[] pBucket = null;

//		Negative Bucket 
		if (neg > 0) {
//			Declare buckets
			int nb = (int) sqrt(pos);
			nBucket = new List[nb];

//			Initialize the buckets
			for (int i = 0; i < nBucket.length; i++) {
				nBucket[i] = new ArrayList();
			}

//			Determine the min value
			int min = 0;

			for (int n : arr) {
				if (min > n) {
					min = n;
				}
			}

//			Distribute elements based on range to respective buckets
			for (int n : arr) {
				if (n < 0) {
					int bi = (n * nBucket.length) / (min - 1);
					nBucket[bi].add(n);

				}
			}

//			Insertion Sort the Bucket 
			for (List nbkt : nBucket) {
				for (int i = 1; i < nbkt.size(); i++) {
					int t = (int) nbkt.get(i);
					int j = i - 1;
					while (j >= 0 && (int) nbkt.get(j) > t) {
						nbkt.set(j + 1, nbkt.get(j));
						j--;
					}
					nbkt.set(j + 1, t);
				}
			}

		}

//		Positive Bucket
		if (pos > 0) {
//			Declare buckets
			int pb = (int) sqrt(pos);
			pBucket = new List[pb];

//			Initialize Buckets
			for (int i = 0; i < pBucket.length; i++) {
				pBucket[i] = new ArrayList();
			}

//			Determin the max value
			int max = 0;

			for (int n : arr) {
				if (max < n) {
					max = n;
				}
			}

//			Distribute elements based on the range to respective buckets
			for (int n : arr) {
				if (n >= 0) {
					int bi = (n * pBucket.length) / (max + 1);
					pBucket[bi].add(n);
				}
			}

			for (List pbkt : pBucket) {
				for (int i = 1; i < pbkt.size(); i++) {
					int t = (int) pbkt.get(i);
					int j = i - 1;
					while (j >= 0 && (int) pbkt.get(j) > t) {
						pbkt.set(j + 1, pbkt.get(j));
						j--;
					}
					pbkt.set(j + 1, t);
				}
			}
		}

		int index = 0;
		if (nBucket != null) {
			for (int i = nBucket.length - 1; i >= 0; i--) {
				for (int j = 0; j < nBucket[i].size(); j++) {
					arr[index++] = (int) nBucket[i].get(j);

				}
			}
		}
		if (pBucket != null) {
			for (List pbkt : pBucket) {
				for (int i = 0; i < pbkt.size(); i++) {
					arr[index++] = (int) pbkt.get(i);
				}
			}
		}

//		System.out.println(Arrays.toString(nBucket));
//		System.out.println(Arrays.toString(pBucket));

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));
	}

	@Override
	public void MergeSort(int[] a) {
		// TODO Auto-generated method stub
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);
		mSort(arr);
		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));

	}

	private static void mSort(int[] arr) {
		if (arr == null) {
			return;
		}
		if (arr.length > 1) {
			int mid = arr.length / 2;

			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];

			for (int i = 0; i < arr.length; i++) {
				if (i < mid) {
					left[i] = arr[i];
				} else {
					right[i - mid] = arr[i];
				}
			}
			mSort(left);
			mSort(right);

			int i = 0, j = 0, k = 0;
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					arr[k++] = left[i++];
				} else {
					arr[k++] = right[j++];
				}
			}
			while (i < left.length) {
				arr[k++] = left[i++];
			}
			while (j < right.length) {
				arr[k++] = right[j++];
			}
		}
	}

	@Override
	public void ShellSort(int[] a) {
		// TODO Auto-generated method stub
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);

		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

//		int n = arr.length; 
//		for(int gap = n/2; gap >0; gap/=2) {
//			for(int i= gap; i< arr.length; i++) {
//				int t = arr[i]; 
//				int j = i; 
//				while(j >= gap && arr[j-gap]>t) {
//					arr[j] = arr[j-gap]; 
//					j-=gap; 
//				}
//				arr[j] = t;
//			}
//		}

		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(arr).length()));

	}

	@Override
	public void QuickSort(int[] a) {
		// TODO Auto-generated method stub
		getMethodName();
		int[] arr = InitializeArray(a);
		printArray(arr);
		qSort(arr, 0, arr.length - 1);
		printArray(arr);
		System.out.println("-".repeat(Arrays.toString(a).length()));
	}

	private static void qSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = new Random().nextInt((high - low) + 1) + low;
			SwapElements(arr, low, pivot);
			int b = low + 1;
			for (int i = b; i <= high; i++) {
				if (arr[i] < arr[low]) {
					SwapElements(arr, i, b++);
				}
			}
			SwapElements(arr, low, b - 1);
			int p = b - 1;
			qSort(arr, low, p - 1);
			qSort(arr, p + 1, high);
		}
	}

	static void Qsort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = arr[high];
			int i = (low - 1);

			for (int j = low; j < high; j++) {
				if (arr[j] <= pivot) {
					i++;
					SwapElements(arr, i, j);
				}
			}
			SwapElements(arr, i + 1, high);
			int pi = i + 1;
			Qsort(arr, low, pi - 1);
			Qsort(arr, pi + 1, high);
		}
	}
	
	static void quicksort(int[] arr, int low, int high) {
		if(low< high) {
			int pivot = new Random().nextInt((high-low)+1)+low;
			SwapElements(arr, high, pivot);
			int b = low; 
			for(int i = b; i < high; i++) { 
				if(arr[i]< arr[high]) { 
					SwapElements(arr, i, b++);
				}
			}
			SwapElements(arr, b, high);
			quicksort(arr, low, b-1);
			quicksort(arr, b+1, high);
		}
	}

	@Override
	public void HeapSort(int[] a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void RedixSort(int[] a) {
		// TODO Auto-generated method stub

	}
}

interface AlgorithmList {
	void BubbleSort(int[] a);

	void SelectionSort(int[] a);

	void InsertionSort(int[] a);

	void BucketSort(int[] a);

	void MergeSort(int[] a);

	void ShellSort(int[] a);

	void QuickSort(int[] a);

	void HeapSort(int[] a);

	void RedixSort(int[] a);

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
