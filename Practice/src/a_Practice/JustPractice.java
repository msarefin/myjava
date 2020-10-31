package a_Practice;

import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Random;

public class JustPractice {

	static int[] a = new int[] { 5, 6, 4, 7, 3, 8, 2, 9, 1, 0, -9, -1, -8, -2, -7, -3, -6, -4, -5 };

	public static void main(String[] args) {
		sorting sort = new sorting();
		sort.new bubble(a);
		sort.new selection(a);
		sort.new insertion(a);
		sort.new bucket(a);
		sort.new merge(a);
		sort.new shell(a);
		sort.new quick(a);
		sort.new heap(a);

	}
}

class helper {

	int[] initialize(int[] a) {
		int[] arr = null;
		if (a == null || a.length == 0) {
			arr = new int[10];
			Random r = new Random();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = r.nextInt(100);
			}
		} else {
			arr = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				arr[i] = a[i];
			}
		}

		return arr;
	}

	static final void swap(int[] a, int m, int n) {
		int t = a[m];
		a[m] = a[n];
		a[n] = t;
	}

	static final void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
}

class sorting extends helper {

	class bubble {

		bubble(int a[]) {
			System.out.println("Bubble Sort");
			int[] arr = initialize(a);
			printArray(arr);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						swap(arr, j, j + 1);
					}
				}
			}
			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}

	class selection {
		public selection(int[] a) {
			System.out.println("Selection Sort");
			int[] arr = initialize(a);
			printArray(arr);
			for (int i = 0; i < arr.length - 1; i++) {
				int t = i;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[t]) {
						swap(arr, j, t);
					}
				}
				swap(arr, i, t);
			}
			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}

	class insertion {
		insertion(int[] a) {
			System.out.println("Insertion Sort");
			int[] arr = initialize(a);
			printArray(arr);

			for (int i = 1; i < arr.length; i++) {
				int min = arr[i];
				int j = i - 1;
				while (j >= 0 && arr[j] > min) {
					arr[j + 1] = arr[j];
					j--;
				}
				arr[j + 1] = min;
			}
			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}

	class bucket {
		bucket(int[] a) {
			System.out.println("Bucket Sort");
			int[] arr = initialize(a);
			printArray(arr);

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}

	class merge {
		merge(int[] a) {
			System.out.println("Merge Sort");
			int[] arr = initialize(a);
			printArray(arr);

			mSort(arr);

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}

		void mSort(int[] arr) {
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
	}

	class quick {
		quick(int[] a) {
			System.out.println("Quick Sort");
			int[] arr = initialize(a);
			printArray(arr);

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}

	class heap {
		heap(int[] a) {
			System.out.println("Heap Sort");
			int[] arr = initialize(a);
			printArray(arr);

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}

		void heapSort(int[] arr) {
			int n = arr.length;
			for (int p = (n - 1) / 2; p >= 0; p--) {
				heapify(arr, n, p);
			}for(int i = n-1; i>=0; i--) { 
				swap(arr, 0, i);
				heapify(arr, i, 0);
			}
		}

		private void heapify(int[] arr, int n, int i) {
			int highest = i;
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			if (l < n && arr[l] > arr[highest]) {
				highest = l;
			}
			if (r < n && arr[r] > arr[highest]) {
				highest = r;
			}
			if (highest != i) {

				swap(arr, i, highest);
				heapify(arr, n, highest);
			}
		}
	}

	class shell {
		shell(int[] a) {
			System.out.println("Shell Sort");
			int[] arr = initialize(a);
			printArray(arr);

			int n = arr.length;
			for (int g = n / 2; g >= 0; g /= 2) {
				for (int i = g; i < n; i++) {
					int temp = arr[i];
					int j = i;
					while (j >= g && arr[j] > temp) {
						arr[j] = arr[j - g];
					}
					arr[j] = temp;
				}
			}

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}
}

class bubble extends helper {

}