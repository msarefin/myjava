package CollectionInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import javax.rmi.CORBA.Stub;

public class ListArrayList {

	public static void main(String[] args) {
		List<String> arl = new ArrayList<String>();
		List<String> ll = new LinkedList<String>();
		List<String> v = new Vector<String>();
		List<String> s = new Stack<String>();

		ArrayList al = new ArrayList(); // Non-generic collection

		ArrayList<String> alg = new ArrayList<String>();

		alg.add("Ravi");
		alg.add("Vijay");
		alg.add("Ravi");
		alg.add("Ajay");

		System.out.println("\nUsing Iterator");

		Iterator it = alg.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("\nUsing For each loop");

		for (String n : alg) {
			System.out.println(n);
		}

		System.out.println("\nUsing ListIterator");

		ListIterator<String> li = alg.listIterator(alg.size());

		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}

		System.out.println("\nUsing For loop");

		for (int i = 0; i < alg.size(); i++) {
			System.out.println(alg.get(i));
		}

		System.out.println("\nUsing forEach()");

		alg.forEach(a -> {
			System.out.println(a);
		});

		System.out.println("\nUsing ForEachRemaining()");

		Iterator<String> itr = alg.iterator();

		itr.forEachRemaining(a -> {
			System.out.println(a);
		});
		
		System.out.println("\nStoring objects");
		
		Students s1 = new Students(101, "Sonoo", 23);
		Students s2 = new Students(102,"Ravi",21);
		Students s3 = new Students(103,"Hanumat", 25);
		
		ArrayList<Students> stl = new ArrayList<Students>();
		
		stl.add(s1);
		stl.add(s2);
		stl.add(s3);
		
		Iterator<Students> its = stl.iterator(); 
		while(its.hasNext()) {
			
			Students st = its.next(); 
			System.out.println(st.roll+" "+st.name+" "+st.age);
		}
		
		
		System.out.println("\nSerialization and Deserialization");
		
		try {
			FileOutputStream fos = new FileOutputStream("file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(alg);
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("file");
			ObjectInputStream ois = new ObjectInputStream(fis); 
			ArrayList list = (ArrayList)ois.readObject();
			
			System.out.println(list+"\n");
			Iterator des = list.iterator();
			while(des.hasNext()) {
				System.out.println(des.next());
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("\nAddingElements");
		
	
		System.out.println(alg);
		
		alg.add(1,"Gaurav");
		
		System.out.println(alg);
		
		ArrayList<String> al2 = new ArrayList<String>(); 
		al2.add("Alex"); 
		al2.add("james");
		al2.add("benjamin"); 
		
		
		
		
		 

	}
}


class Students{
	
	int roll; 
	String name; 
	int age; 
	
	Students(int roll, String name, int age){
		this.roll = roll; 
		this.name = name; 
		this.age = age; 
	}
}