package newPractice;

import java.util.Scanner;

public class Practice {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter you name:");
		
		String name = "Hello," + sc.nextLine()+"! welcome to learning Core Java!"; 
		
		System.out.println(name);
	}
	
}