package a_Practice;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

	static final void swap(int[] arr, int m, int n) {
		int t = arr[m];
		arr[m] = arr[n];
		arr[n] = t;
	}

	static final void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}

	static final double sqrt(double n) {
		double t;
		double sq = n / 2;
		do {
			t = sq;
			sq = (t + (n / t)) / 2;
		} while ((t - sq) != 0);
		return sq;
	}
}

class searching extends sorting{
	class linear{ 
		linear(int [] arr, int n){ 
			new bubble(arr); 
			for(int i = 0; i< arr.length; i++) { 
				while(arr[i]==n) { 
					System.out.println(n+" Found at index "+i);
				}
			}
		}
	}
	class binary{
		binary(int [] arr, int n){ 
			new insertion(arr); 
			int l = 0, r= arr.length-1; 
			int m = 0; 
			while(l< r) { 
				m = l+(r-l)/2;
				if(arr[m]==n) {
					System.out.println(n+" was found at index "+m);
				}else if(arr[m]>n) {
					r = m-1;
				}else { 
					l = m+1;
				}
				
				if(l>r)
					System.out.println(n+" was not found in list!!");
			}
			
		}
		
	}
	class interpolation{ 
		public interpolation(int [] arr, int n) {
			int l = 0 , h = arr.length-1;
			while(l<=h && n  >=arr[l] && n<= arr[h]) {
				if(l == h) { 
					if(arr[l]==n) { 
						System.out.println("element found at "+l);
					}else {
						System.out.println("element was not found");
					}
				}
				int pos = l+((h-l)*((n-arr[l])/(arr[h]-arr[l]))); 
				if(arr[pos]==n) { 
					System.out.println("element found at "+pos);
				}else if(arr[pos]<n) { 
					l = pos+1; 
				}else { 
					h = pos-1; 
				}
			}
		}
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

			int neg = 0;
			int pos = 0;

			for (int n : arr) {
				if (n < 0) {
					neg++;
				} else {
					pos++;
				}
			}

			List[] nBucket = null;
			List[] pBucket = null;

			if (neg > 0) {

				int nb = (int) sqrt(neg);
				nBucket = new List[nb];
				for (int i = 0; i < nBucket.length; i++) {
					nBucket[i] = new ArrayList();
				}

				int min = 0;
				for (int n : arr) {
					if (min > n) {
						min = n;
					}
				}
				for (int n : arr) {
					if (n < 0) {
						int bi = (n * nBucket.length) / (min - 1);
						nBucket[bi].add(n);
					}
				}
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

			if (pos > 0) {

				int pb = (int) sqrt(pos);
				pBucket = new List[pb];
				for (int i = 0; i < pBucket.length; i++) {
					pBucket[i] = new ArrayList();
				}

				int max = 0;
				for (int n : arr) {
					if (max < n) {
						max = n;
					}
				}
				for (int n : arr) {
					if (n >= 0) {
						int bi = (n * pBucket.length) / (max + 1);
						pBucket[bi].add(n);
					}
				}
				System.out.println(Arrays.toString(pBucket));
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
				for (int i = nBucket.length-1; i >= 0; i--) {
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
			quickSort(arr, 0, arr.length - 1);
			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}

		final private void quickSort(int[] arr, int low, int high) {
			if (low < high) {
				int pivotIndex = new Random().nextInt((high - low) + 1) + low;
				swap(arr, pivotIndex, high);
				int b = low;
				for (int i = b; i < high; i++) {
					if (arr[i] < arr[high]) {
						swap(arr, i, b++);
					}
				}
				swap(arr, b, high);
				quickSort(arr, low, b - 1);
				quickSort(arr, b + 1, high);

			}
		}
	}

	class heap {
		heap(int[] a) {
			System.out.println("Heap Sort");
			int[] arr = initialize(a);
			printArray(arr);
			heapSort(arr);
			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}

		void heapSort(int[] arr) {
			int n = arr.length;
			for (int p = (n - 1) / 2; p >= 0; p--) {
				heapify(arr, n, p);
			}
			for (int i = n - 1; i >= 0; i--) {
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
			for (int g = n / 2; g > 0; g /= 2) {
				for (int i = g; i < n; i++) {
					int temp = arr[i];
					int j = i;
					while (j >= g && arr[j - g] > temp) {
						arr[j] = arr[j - g];
						j -= g;
					}
					arr[j] = temp;
				}
			}

			printArray(arr);
			System.out.println("=".repeat(Arrays.toString(arr).length()));
		}
	}
}
