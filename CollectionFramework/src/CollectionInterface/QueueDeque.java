package CollectionInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueDeque {
	public static void main(String[] args) {

		Deque<String> dq = new ArrayDeque<String>(); 
		dq.add("Ravi"); 
		dq.add("Vijay"); 
		dq.add("Ajay"); 
		
		for(String n: dq) {
			System.out.print(n+"\t");
		}
		System.out.println();
		System.out.println(dq);
		
		dq.offerFirst("Jai"); 
		dq.offerLast("SukumarRamasundarVenkataAyier");
		
		System.out.println(dq);
		
		dq.pollLast(); 
		dq.pollLast(); 
		
		System.out.println(dq);
		
		dq.poll(); 
		
		System.out.println(dq);
		
		
		
	}
}
