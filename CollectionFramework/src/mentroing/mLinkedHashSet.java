package mentroing;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class mLinkedHashSet {

	public static void main(String[] args) {

		LinkedHashSet<String> lhs = new LinkedHashSet<String>();

		lhs.add("one");
		lhs.add("Two");
		lhs.add("Three");
		lhs.add("Four");
		lhs.add("Danny");
		lhs.add("Danny");

		
		lhs.remove("Three");
		
		
		
		
		iter(lhs);
		
		
		

	}
	
	static void iter(LinkedHashSet l) {
		
		Iterator it = l.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
	}

}
