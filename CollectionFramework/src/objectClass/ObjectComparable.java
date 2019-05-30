package objectClass;

import java.util.ArrayList;
import java.util.Collections;

public class ObjectComparable {

	public static void main(String[] args) {
		ArrayList<student1> a = new ArrayList<student1>(); 
		
		a.add(new student1(101, "Vijay", 23)); 
		a.add(new student1(106, "Ajay", 27)); 
		a.add(new student1(105, "Jai", 21)); 
		
		Collections.sort(a); 
		
		for(student1 st: a) {
			System.out.println(st.rollno+" "+st.name+" "+st.age);
		}
		
		System.out.println();
		
		ArrayList<student1reverse> ar = new ArrayList<student1reverse>();
		
		ar.add(new student1reverse(101, "Vijay", 23)); 
		ar.add(new student1reverse(106, "Ajag", 27)); 
		ar.add(new student1reverse(105, "Jai", 21));
		
		Collections.sort(ar);
	
		for(student1reverse r: ar) {
			System.out.println(r.rollno+" "+r.name+" "+r.age);
		}
		
	}
}

class student1 implements Comparable<student1> {

	int rollno, age;
	String name;

	public student1(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;

	}

	public int compareTo(student1 s) {
		if (age == s.age)
			return 0;
		else if (age > s.age)
			return 1;
		else
			return -1;
	}

}

class student1reverse implements Comparable<student1reverse> {

	int rollno, age;
	String name; 
	
	public student1reverse(int rollno, String name, int age) {
		this.age = age; 
		this.name = name; 
		this.rollno =rollno; 
		
	}
	
	
	public int compareTo(student1reverse s) {
		
		
		if(age == s.age) return 0; 
		else if(age <s.age) return 1; 
		else return -1;
	
	}
}