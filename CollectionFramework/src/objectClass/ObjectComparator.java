package objectClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ObjectComparator {

	public static void main(String[] args) {
		ArrayList al = new ArrayList(); 
		
		al.add(new student3(101, "Vijay", 23)); 
		al.add(new student3(106, "Ajay", 27)); 
		al.add(new student3(105, "Jai", 21)); 
		
		Collections.sort(al,new NameComparator());
		Iterator it = al.iterator(); 
		
		while(it.hasNext()) {
			
			student3 s = (student3) it.next();
			System.out.println(s.rollno+" "+s.name+" "+s.age);
		}
		
		System.out.println();
		
		Collections.sort(al, new AgeComparator());
		
		Iterator it2 = al.iterator(); 
		while(it2.hasNext()) {
			student3 s = (student3) it2.next();  
			System.out.println(s.rollno+" "+s.name+" "+s.age);
		}
		
	}
	
}

class student3 {
	int rollno, age;
	String name;

	public student3(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}

class AgeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		student3 s1 = (student3) o1;
		student3 s2 = (student3) o2;

		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;

	}

}

class NameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		student3 s1 = (student3) o1; 
		student3 s2 = (student3) o2; 
		
		
		return s1.name.compareTo(s2.name);
	}
	
}