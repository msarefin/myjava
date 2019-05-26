package CollectionInterface;

import java.util.PriorityQueue;

public class QueuePriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<String>();

		queue.add("Amit");
		queue.add("Vijay");
		queue.add("Karen");
		queue.add("Jai");
		queue.add("Rahul");

		System.out.println(queue.element());

		System.out.println(queue.peek());
		
		System.out.println(queue);
		queue.remove(); 
		System.out.println(queue);
		queue.poll(); 
		
		
		System.out.println(queue);
		
		
		
	}
}
