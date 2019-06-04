package sortingAlgorithms;

import java.util.Random;

public class SelectionSort {

	static int ar[];

	public static void main(String[] args) {
		ar = new int[100];

		for (int i = 0; i < ar.length; i++) {

			ar[i] = new Random().nextInt(200);

			System.out.println(ar[i]);
		}

	}

}
