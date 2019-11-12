package searchingAlgorithm;

public class INterpolationSearch {

	static int[] arr = new int[] { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47 };

	static int interpoationSearch(int x) {
		int lo = 0;
		int hi = (arr.length - 1);

		while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
			if (lo == hi) {
				if (arr[lo] == x)
					return lo;
				return -1;
			}

			int pos = lo + (((hi - lo)* (x - arr[lo]) / (arr[hi] - arr[lo])) );
			
			if(arr[pos] ==x) return pos; 
			if (arr[pos]<x) lo = pos+1;
			else hi = pos-1; 
			
		}
		return -1; 
	}
	
	public static void main(String[] args) {
		int x = 18; 
		int index = interpoationSearch(x); 
		
		if(index !=-1) {
			System.out.println("Element found at index "+index);
		}else {
			System.out.println("Element not found");
		}
	}

}
