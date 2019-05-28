package mentroing;

import java.util.*;

public class mLinkedList {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("danny");
		ll.add("james");
		ll.add("alex");
		ll.add("Sam");
		ll.add("alex");
		ll.add("alex");
		ll.add("alex");

		Iterator it = ll.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();

		for (String s : ll) {
			System.out.println(s);
		}

		System.out.println();
		ll.add(1, "Gaurav");

		it = ll.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();

		LinkedList<String> ll1 = new LinkedList<String>();

		ll1.add("Ram");
		ll1.add("vishnu");
		ll1.add("hari");
		ll.add("alex");
		ll1.add("ramesh");

		for (String s : ll1) {
			System.out.println(s);
		}

		System.out.println();

		ll1.addAll(2, ll);

		for (String s : ll1) {
			System.out.println(s);
		}

		ll1.addFirst("first Element");
		ll1.addLast("last element");

		System.out.println();
		for (String s : ll1) {
			System.out.println(s);
		}

		System.out.println();

		ll1.remove("Ram");

		ll1.remove(3);
		
		ll1.removeFirst(); 
		ll1.removeLast();
		
		ll1.removeFirstOccurrence("alex");
		
		ll1.removeLastOccurrence("alex");
		
		ll1.removeAll(ll);
		
		ll1.clear();
		
		
		System.out.println(ll1);

		System.out.println();
		for (String s : ll1) {
			System.out.println(s);
		}
	}

}
