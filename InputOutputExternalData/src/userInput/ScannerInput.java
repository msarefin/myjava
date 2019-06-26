package userInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = 0;
		String name = null;
		ArrayList<students> studentsList = new ArrayList<students>();
		
		

		try {
			System.out.println("How many students do you want to add");
			size = sc.nextInt();

			for (int i = 0; i < size; i++) {
				System.out.println("Enter Student # " + (i + 1));
				name = sc.next();
				System.out.println("Enter Student GPA ");
				double gpa = sc.nextDouble(); 
				students st = new students(name, gpa);
				studentsList.add(st);
				
			}

		} catch (InputMismatchException ex) {
			System.out.println("Please enter valid integer");
		}
		
		finally {
			for(students st: studentsList) {
				System.out.println(st.nameGetter());
				System.out.println(st.gpaGetter());
			}
		}

	}

}


class students{
	
	private String name; 
	private double gpa; 
	
	 students(String name, double gpa) {
		this.name = name; 
		this.gpa = gpa; 
	}
	
	
	 String nameGetter() {
		 return name; 
	 }
	 
	 double gpaGetter() {
		 return gpa;
	 }
	
}