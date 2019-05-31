package dataStructureAlgorithm;

import java.util.Stack;

public class workingOnArray {

	public static void main(String[] args) {

		long[] arr;
		arr = new long[100];

		int nElems = 0;

		int j;

		long searchKey;

		arr[0] = 77; // insert 10 items
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 00;
		arr[8] = 66;
		arr[9] = 33;
		nElems = 10;

		searchKey = 66;

		for (j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
			if (arr[j] == searchKey) {
				System.out.println("found " + searchKey);

				if (j == arr.length) {
					System.out.println("Element not found in list");
				} else {
					System.out.println("Element was found!!!");
				}
			}
		}

	}

}
