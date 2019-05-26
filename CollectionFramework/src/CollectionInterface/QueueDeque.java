package CollectionInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDeque {
	public static void main(String[] args) {

		Deque<String> dq = new ArrayDeque<String>(); 
		dq.add("Ravi"); 
		dq.add("Vijay"); 
		dq.add("Ajay"); 
		
		System.out.println(dq);
		
		dq.offerFirst("Jai"); 
		
		System.out.println(dq);
		
		dq.pollLast(); 
		
		System.out.println(dq);
		
	}
}
