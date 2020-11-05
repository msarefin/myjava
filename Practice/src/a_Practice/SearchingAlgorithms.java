package a_Practice;

import java.util.Random;

public class SearchingAlgorithms{
	
	static int[] arr = null;
	
	public static void main(String[] args) {
		arr = new SearchingAlgorithms().new helper().initialize(arr, 100);
		new SearchingAlgorithms().new linearSearch(arr, 45); 
		
	}
	
	
	protected class linearSearch{ 
		public linearSearch(int [] arr, int num) {
			for(int i = 0 ; i< arr.length; i++) { 
				while(arr[i]==num) { 
					System.out.println("Found number at index: "+i);
					return; 
				} 
			}
		}
	}
	
	protected class binarySearch{
		public binarySearch(int [] arr, int n) {
			
		}
	}
	
	private class helper{
		int[] initialize(int [] a, int numberOfElements) {
			while(a==null) { 
				a = new int[numberOfElements];
				for(int i = 0; i< a.length; i++) {
					a[i] = new Random().nextInt(numberOfElements*10); 
				}
			}
			return a; 
		}
	}

}

