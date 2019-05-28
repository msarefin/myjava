package MapInterface;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapHashMap {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(1, "Amit");
		map.put(2, "Rahul");
		map.put(3, "Jai");
		map.put(4, "Amit");

		Set set = map.entrySet();

		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();

			System.out.println(entry.getKey() + " | " + entry.getValue());

		}

		System.out.println();

		Map<Integer, String> gMap = new HashMap<Integer, String>();

		gMap.put(101, "Rahman");
		gMap.put(102, "Ali");
		gMap.put(103, "Muhammed");
		gMap.put(104, "Amin");
		gMap.put(105, "Haidar");

		for (Map.Entry m : gMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println();

		gMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(System.out::println);

		System.out.println();

		gMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
				.forEach(System.out::println);

		System.out.println();
		gMap.putAll(map);

		gMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(System.out::println);

		System.out.println();
		Set gset = gMap.entrySet();

		it = gset.iterator();

		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			System.out.println(m.getKey() + " " + m.getValue());
		}

		Map<Integer, String> mm = gMap;

		mm.remove(105);
		mm.remove(4, "Amit");

		System.out.println();

		for (Map.Entry m : mm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		mm.putIfAbsent(23, "Alexander");

		mm.replace(102, "Hani");

		mm.replace(1, "Amit", "Sid");

		mm.replaceAll((k, v) -> "Alice");

		System.out.println();

		for (Map.Entry m : mm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		set = gMap.entrySet();

		it = set.iterator();

		while (it.hasNext()) {
			Map.Entry aMap = (Map.Entry) it.next();

//			mm.putIfAbsent(aMap.getKey(), aMap.getValue());
		}
		
		System.out.println();

		Map<Integer, MapBook> mbook = new HashMap<Integer, MapBook>();

		MapBook b1 = new MapBook(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		MapBook b2 = new MapBook(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		MapBook b3 = new MapBook(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Books to map

		mbook.put(1, b1);
		mbook.put(2, b2);
		mbook.put(3, b3);

		for (Map.Entry<Integer, MapBook> book : mbook.entrySet()) {
			int key = book.getKey();
			MapBook bk = book.getValue();
			System.out.println(key + ":" + bk.id + " | " + bk.name + " | " + bk.author + " | " + bk.publisher + " | " + bk.qty);

		}

	}
}

class MapBook {

	int id, qty;
	String name, author, publisher;

	public MapBook(int id, String name, String author, String publisher, int qty) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.qty = qty;
	}

}
