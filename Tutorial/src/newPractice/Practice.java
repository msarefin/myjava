package newPractice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter integer numbers");
		int sum = 0,  count =0; 
		double avg = 0;
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			if(n>0) {
				sum+=n; 
				count++; 	
			}else {
				sum+=0; 
			}
		}
		avg = sum/count; 
		System.out.println("your average is "+avg);
	}
}