package OOPConcepts;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		userEntry();
	}
	
	static void userEntry() {
		System.out.println("Please Enter a number: ");
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		rightTriangle(n);
	}
	
	static void rightTriangle(int n) {
		for(int i = 0; i<= n; i++) {
			for(int j = 0; j <=i; j++) {
				System.out.print(j+" ");
			}
				System.out.println();
		}
	}
	
}
