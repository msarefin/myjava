package MapInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapLinkedHashMap {

	public static void main(String[] args) {

		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();

		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println();

		System.out.println(hm.keySet());
		System.out.println();
		System.out.println(hm.values());

		System.out.println(hm.keySet() + " " + hm.values());

		System.out.println();
		System.out.println(hm);

		hm.remove(102);

		System.out.println(hm);

		LinkedHashMap<Integer, lhmBook> book = new LinkedHashMap();

		lhmBook b1 = new lhmBook(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		lhmBook b2 = new lhmBook(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		lhmBook b3 = new lhmBook(103, "Operating System", "Galvin", "Wiley", 6);

		book.put(2, b2);
		book.put(1, b1);
		book.put(3, b3);
		
		for(Map.Entry<Integer, lhmBook> entry: book.entrySet()) {
			int key = entry.getKey(); 
			lhmBook value = entry.getValue(); 
			
			System.out.println(key+" : "+value.id+" "+value.name+" "+value.author+" "+value.publisher+" "+value.qty);
		}
		

	}

}

class lhmBook {

	int id, qty;
	String name, author, publisher;

	public lhmBook(int id, String name, String author, String publisher, int qty) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.qty = qty;
	}

}
