package CollectionInterface;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class SetLinkedHashSet {

	public static void main(String[] args) {

		LinkedHashSet<String> lhs = new LinkedHashSet<String>();

		lhs.add("One");
		lhs.add("Two");
		lhs.add("Three");
		lhs.add("Four");
		lhs.add("Five");

		Iterator<String> it = lhs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();

		LinkedHashSet<String> al = new LinkedHashSet<String>();

		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");

		System.out.println(al);

		Booklhs b1 = new Booklhs(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Booklhs b2 = new Booklhs(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Booklhs b3 = new Booklhs(103, "Operating System", "Galvin", "Wiley", 6);

		LinkedHashSet<Booklhs> b = new LinkedHashSet<Booklhs>();

		b.add(b1);
		b.add(b2);
		b.add(b3);

		Iterator<Booklhs> book = b.iterator();
		while (book.hasNext()) {
			Booklhs b11 = book.next();
			System.out.println(b11.id + " " + b11.name + " " + b11.author + " " + b11.publisher + " " + b11.qty);
		}

	}

}

class Booklhs {

	int id, qty;
	String name, author, publisher;

	Booklhs(int id, String name, String author, String publisher, int qty) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.qty = qty;

	}
}
