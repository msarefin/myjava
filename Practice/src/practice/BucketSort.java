package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class BucketSort {

	public static void main(String[] args) {
		int [] arr = new int[] {5,2,8,7,4,1,9,6,3,0,10,-1,-2};
		System.out.println("Unsorted Array:");
		printArray(arr);
		bucketSort(arr);
		System.out.println("Sorted Array:");
		printArray(arr);
		
	}
	
	static void bucketSort(int [] arr) {
		
		
		int bucketSize = (int) Math.sqrt(arr.length); 
		System.out.println("Number of buckets: "+bucketSize);
		List [] bucket = new List[bucketSize];
		
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList(); 
		}
		
		int max = maxValue(arr);
		System.out.println("Maximum value in the array: "+ max);
		
		for (int i = 0; i < arr.length; i++) {
			int bi = (arr[i]*bucketSize)/(max+1);
			
			bucket[bi].add(arr[i]); 
		}
		System.out.println("Unsorted Buckets");
		for (int i = 0; i < bucket.length; i++) {
			System.out.println("Bucket:"+bucket[i]);
		}
		
		for (int i = 0; i < bucket.length; i++) {
			Collections.sort(bucket[i]);
		}
		
		System.out.println("Sorted Buckets");
		for (int i = 0; i < bucket.length; i++) {
			System.out.println("Bucket:"+bucket[i]);
		}
		int index =0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				arr[index++] = (int) bucket[i].get(j); 
			}
		}
		
	}
	
	
	static void printArray(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static int maxValue(int [] arr) {
		int max = arr[0]; 
		for (int i = 1; i < arr.length; i++) {
			if(max< arr[i]) {
				max = arr[i]; 
			}
		}
		return max; 
	}
}
