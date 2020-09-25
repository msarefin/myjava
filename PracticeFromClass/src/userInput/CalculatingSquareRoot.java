package userInput;

import java.util.Scanner;

public class CalculatingSquareRoot {

	public static void main(String[] args) {
		System.out.println("Please Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double n = squareRoot(num);
		System.out.println("The Square root of " + num + " is : " + n);

	}

	static double squareRoot(int num) {
		double temp;
		double sr = num / 2;
		do {
			temp = sr;
			sr = (temp + (num / temp)) / 2;
		} while ((temp - sr) != 0);
		return sr;
	}

}
