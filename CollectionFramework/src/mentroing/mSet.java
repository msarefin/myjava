package mentroing;

import java.util.*;

public class mSet {
	public static void main(String[] args) {

		Set set = new HashSet<String>();

		set.add("one");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Danny");

//		System.out.println();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		set.remove("Danny");

		System.out.println();

		it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		HashSet<String> hs = new HashSet<String>();

		hs.add("Ram");
		hs.add("vishnu");
		hs.add("hari");
		hs.add("ramesh");
		
		
		
		set.addAll(hs);

		System.out.println();

		it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		HashSet<String> c = new HashSet<String>();

		c.add("vishnu");
		c.add("hari");

		set.removeAll(c);

		System.out.println();

		it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
//		set.clear();
		System.out.println(set);
		

	}
}
