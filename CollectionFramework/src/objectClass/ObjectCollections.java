package objectClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ObjectCollections {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(46);
		list.add(67);
		list.add(24);
		list.add(16);
		list.add(8);
		list.add(12);

		System.out.println(Collections.min(list));

		ArrayList<String> al = new ArrayList<String>();
		al.add("Viru");
		al.add("Saurav");
		al.add("Mukesh");
		al.add("Tarun");

		System.out.println();

		Collections.sort(al, Collections.reverseOrder()); // Sort string object

		Iterator itr = al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		ArrayList l = new ArrayList();
		l.add(201);
		l.add(230);
		l.add(101); // internally will be converted into objects as Integer.valueOf(230)

		Collections.sort(al);

		itr = l.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		
		ArrayList<Student> al1=new ArrayList<Student>();  
	      al1.add(new Student("Viru"));  
	      al1.add(new Student("Saurav"));  
	      al1.add(new Student("Mukesh"));  
	      al1.add(new Student("Tahir"));  //user defined class objects
	      
	    Collections.sort(al1);  
	    for (Student s : al1) {  
	      System.out.println(s.name);  
	    }  

	}
}


class Student implements Comparable<Student>{
	public String name; 
	
	public Student(String name) {
		this.name = name; 
	}
	

	@Override
	public int compareTo(Student person) {
		// TODO Auto-generated method stub
		return name.compareTo(person.name);
	}
}