package userInput;

import java.util.Scanner;

public class InputFromUser {
	
	

	public static void main(String[] args) {
		System.out.println("Please enter text here:\n");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("You entered :\n"+sc.nextLine());
	}
	
}
