package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {

		ArrayList<stdnt> at = new ArrayList<stdnt>(); 
		at.add(new stdnt(101, "Vijay", 23));
		at.add(new stdnt(106, "ajay", 27)); 
		at.add(new stdnt(105, "jai", 21)); 
		
		Collections.sort(at);
		
		for(stdnt st:at) {
			System.out.println(st.rollno+" "+st.name+" "+st.age);
		}
	}
}

class stdnt implements Comparable<stdnt> {
	int rollno;
	String name;
	int age;

	public stdnt(int rollno, String name, int age) {
		// TODO Auto-generated constructor stub

		this.rollno = rollno;
		this.name = name;
		this.age = age;

	}

	@Override
	public int compareTo(stdnt st) {
		if (age == st.age)
			return 0;
		else if (age < st.age)
			return 1;
		else
			return -1;
	}
}