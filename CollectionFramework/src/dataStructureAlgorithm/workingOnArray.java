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

		for (j = 0; j < nElems; j++) {
			System.out.print(arr[j] + " ");
			if (arr[j] == searchKey) {
				System.out.println("found " + searchKey);

				if (j == arr.length) {
					System.out.println("Element not found in list");
				} else {
					System.out.println("Element was found!!!");
				}
			}
		}

		// Delete elements

		System.out.println("\nDelete Elements\n");

		searchKey = 55;

		for (j = 0; j < nElems; j++)
			if (arr[j] == searchKey)
				break;
		for (int k = j; k < nElems; k++)
			arr[k] = arr[k + 1];
		nElems--;

		for (int i = 0; i < nElems; i++)
			System.out.print(arr[i] + " ");

		System.out.println(" ");
		
		
		System.out.println(a.length);
		
		System.out.println(find(55));
		
		
		

	}

	static int a[] = {11,22,33,44,55,66,77,88,99,101,202,303,404};
	static int nElems = a.length;
	static int searchKey = 0;

	public static int find(long search) {
		int lowerBound = 0;
		int upperBound = nElems - 1; //5

		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2; //4
			if (a[curIn] == searchKey) // 55 ==55
				return curIn;
			else if (lowerBound > upperBound)// 0 > 2
				return nElems;
			else {
				if (a[curIn] < searchKey) // 33 < 55
					lowerBound = curIn + 1; // 3
				else
					upperBound = curIn - 1; // 5

			}

		}
	}

}
