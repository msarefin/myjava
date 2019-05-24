package CollectionInterface;

import java.util.*;

public class ListLinkedList {

	public static void main(String[] args) {
		LinkedList<String> al = new LinkedList<String>();

		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");

		Iterator<String> itr = al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println(al);

		al.add(1, "Gaurav");

		System.out.println(al);

		LinkedList<String> ll2 = new LinkedList<String>();

		ll2.add("Soroo");
		ll2.add("Hauntmat");

		al.addAll(ll2);
		System.out.println(al);

		LinkedList<String> ll3 = new LinkedList<String>();
		ll3.add("John");
		ll3.add("Rahul");

		Iterator itrr = al.descendingIterator();
		while (itrr.hasNext()) {
			System.out.println(itrr.next());
		}

		al.addAll(2, ll3);

		System.out.println(al);

		al.addFirst("Lokesh");

		System.out.println(al);

		al.addLast("Harsh");

		System.out.println(al);

		al.remove("Vijay");

		System.out.println(al);

		al.remove(2);

		System.out.println(al);

		al.removeFirst();

		System.out.println(al);

		al.removeLast();

		System.out.println(al);

		al.removeFirstOccurrence("John");

		System.out.println(al);

		al.removeAll(ll2);

		System.out.println(al);

		al.removeLastOccurrence("Ravi");

		System.out.println(al);

		al.clear();

		System.out.println(al);

		Book b1 = new Book(101, "Learn C", "abc", "Penguin", 10);
		Book b2 = new Book(102, "Data Structure", "bbc", "McGraw Hills", 22);
		Book b3 = new Book(103, "Java", "dsf", "Sybex", 23);

		LinkedList<Book> b = new LinkedList<Book>();

		b.add(b1);
		b.add(b2);
		b.add(b3);

		for (Book bk : b) {
			System.out
					.println(bk.id + " , " + bk.name + " , " + bk.author + " , " + bk.publisher + " , " + bk.quantity);
		}

	}
}

class Book {

	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

}
