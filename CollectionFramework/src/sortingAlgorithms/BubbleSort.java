package sortingAlgorithms;

import java.util.Random;

public class BubbleSort {

	static int ar[];

	public static void main(String[] args) {
		Random r = new Random();

		ar = new int[100];

		for (int i = 0; i < ar.length; i++) {

			ar[i] = r.nextInt(200);

			System.out.println(ar[i]);

		}

	}

}
