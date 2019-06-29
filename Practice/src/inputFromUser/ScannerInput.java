package inputFromUser;

import java.io.BufferedReader;

import java.util.Scanner;

public class ScannerInput {

	public static void main(String[] args) {

		System.out.println("What is your name ?");

		Scanner sc = new Scanner(System.in);

//		String input = sc.nextLine(); 
//		String input1 = sc.next(); 

		System.out.println("Hello, " + sc.next());

		System.out.println("What can i do for you, " + sc.nextLine() + " ?");

		sc.close();
	}

}
