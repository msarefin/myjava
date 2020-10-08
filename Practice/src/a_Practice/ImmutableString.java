package a_Practice;

import java.awt.Point;

public class ImmutableString {

	String s1 = "hi";
	String s2 = "hi";

	int x = 1, y = 1;

	public static void main(String[] args) {
//		Point myPoint = new Point(0, 0);
//		System.out.println(myPoint);
//		myPoint.setLocation(1.0, 0.0);
//		System.out.println(myPoint);
		
//		Immutable object example
		String myString = new String("Old String"); 
		System.out.println(myString);
		myString.replaceAll("Old", "New");
		System.out.println(myString);
		
//		Immutable Object example
		String s = "How";
		System.out.println(s); 
		s.concat(" Are you ?");
		System.out.println(s);
		
	}
}
