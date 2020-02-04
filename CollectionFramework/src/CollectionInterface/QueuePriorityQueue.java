package CollectionInterface;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueuePriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>();

		queue.add("Amit");
		queue.add("Vijay");
		queue.add("Karen");
		queue.add("Jai");
		queue.add("Rahul");

		System.out.println("queue.element(): "+queue.element());

		System.out.println("queue.peek(): "+queue.peek());
		
		Iterator it = queue.iterator(); 
		while(it.hasNext()) {
			System.out.print(it.next()+"\t");
		}
		System.out.println();
		System.out.println(queue);
		queue.remove(); 
		System.out.println(queue);
		queue.poll(); 
		
		
		System.out.println(queue);
		
		
		
	}
}
