package CollectionInterface;

import java.util.Iterator;
import java.util.TreeSet;

public class SetSortedSetTreeSet {

	public static void main(String[] args) {
	
		TreeSet<String> ts = new TreeSet<String>(); 
		
		ts.add("Ravi"); 
		ts.add("Vijay");
		ts.add("Ravi"); 
		ts.add("Ajay"); 
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		
		TreeSet<String> set = new TreeSet<String>(); 
		
		set.add("Ravi"); 
		set.add("Vijay"); 
		set.add("Ajay"); 
		
		Iterator<String> itr = set.descendingIterator(); 
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		TreeSet<Integer> set1 = new  TreeSet<Integer>(); 
		set1.add(24); 
		set1.add(66); 
		set1.add(12); 
		set1.add(15); 
		
		System.out.println(set1.pollFirst());
		System.out.println(set1.pollLast());
		
		System.out.println(set1);
		
		
		TreeSet<String> s = new TreeSet<String>();
		s.add("A");
		s.add("B");
		s.add("C");
		s.add("D");
		s.add("E");
		
		System.out.println("\n"+s);//ascending order
		System.out.println(s.descendingSet()); //Descending order 
		System.out.println(s.headSet("C",true));//all elements before c including c
		System.out.println(s.subSet("A", false , "E" ,true)); // All elements between A and E , not displaying A but displaying E
		System.out.println(s.tailSet("C",false)); // All Elements after C , excluding C
		System.out.println(s.subSet("A", "E")); // All elements between A and E
		System.out.println(s.tailSet("C")); // All Elements after C
		
		
	}
	
}
