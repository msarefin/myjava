package newPractice;

import java.util.Scanner;

public class InputFromUser {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("What is your name? \n");
		String n = sc.nextLine().trim();
		System.out.println("Hello, " + n + " !");
	}

	private static void userInput(int n) {

	}

}
