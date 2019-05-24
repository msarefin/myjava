package CollectionInterface;

import java.util.HashSet;
import java.util.Iterator;

public class SetHashSet {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>(); 
		set .add("One"); 
		set.add("Two"); 
		set.add("Three"); 
		set.add("Four"); 
		set.add("Five"); 
		
		Iterator<String> iter = set.iterator(); 
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		HashSet<String> hs = new HashSet<String>(); 
		
		hs.add("Ravi"); 
		hs.add("Vijay"); 
		hs.add("Ravi"); 
		hs.add("Ajay");
		
		Iterator<String> it = hs.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Danny"); 
		set1.add("Samantha"); 
		set1.add("Sononomo");
		
		hs.addAll(set1);
		
		System.out.println(hs);
		
		hs.removeAll(set1);
		
		System.out.println(hs);
		
		hs.removeIf(str->str.contains("Vijay")); 
		System.out.println(hs);
		
		
		HashSet<String> hs1 = new HashSet<String>(hs);
		System.out.println(hs1);
		
		hs1.add("Yousuf");
		hs.clear();
		
		
		System.out.println(hs1);
		
		
		
		
	}
	
}


class Bookhs{
	int id; 
	String name, author, publisher; 
	int quanity; 
	
	Bookhs(int id, String name, String author, String publisher, int quantity){
		
	}
	
}