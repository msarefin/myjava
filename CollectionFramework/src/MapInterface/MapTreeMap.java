package MapInterface;

import java.util.Map;
import java.util.TreeMap;

public class MapTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

		tm.put(100, "Amit");
		tm.put(102, "Ravi");
		tm.put(101, "Vijay");
		tm.put(103, "Rahul");

		TreeMapIterator(tm);

//		tm.remove(102); 

		TreeMapIterator(tm);

		System.out.println(tm.descendingMap());
		System.out.println(tm.descendingKeySet());

		System.out.println(tm.headMap(102, true)); // keys less than the specified key
		System.out.println(tm.tailMap(102, true)); // keys greater than the specified key
		System.out.println(tm.subMap(100, false, 103, false)); // keys between range
		System.out.println("hffjhg");
		System.out.println(tm.headMap(102));
		System.out.println(tm.tailMap(102));
		System.out.println(tm.subMap(100, 103));
		
		System.out.println();

		TreeMap<Integer, mbook> booktm = new TreeMap<Integer, mbook>();

		mbook b1 = new mbook(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		mbook b2 = new mbook(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		mbook b3 = new mbook(103, "Operating System", "Galvin", "Wiley", 6);

		booktm.put(1, b1);
		booktm.put(2, b2);
		booktm.put(3, b3);
		
		for(Map.Entry<Integer, mbook> book : booktm.entrySet()) {
			int key = book.getKey(); 
			mbook value = book.getValue();
			
			System.out.println(key+" : "+value.id+" "+value.name+" "+value.author+" "+value.publisher+" "+value.qty);
		}
		
	}

	static void TreeMapIterator(TreeMap<Integer, String> tm) {
		for (Map.Entry m : tm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println();

		

	}

}

class mbook {

	int id, qty;
	String name, author, publisher;

	public mbook(int id, String name, String author, String publisher, int qty) {

		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.qty = qty;

	}
}