package MapInterface;

import java.util.Hashtable;
import java.util.Map;

public class MapHashTable {

	public static void main(String[] args) {
		Hashtable<Integer, String> hm = new Hashtable<Integer, String>();

		hm.put(100, "Amit");
		hm.put(102, "Ravi");
		hm.put(101, "Vijay");
		hm.put(103, "Rahul");

		System.out.println(hm);

		output(hm);

		hm.remove(102);

		output(hm);

		System.out.println(hm.getOrDefault(103, "Not Found"));
		System.out.println(hm.getOrDefault(105, "Not Found"));

		hm.putIfAbsent(107, "Mark");
		System.out.println(hm);

	}

	static void output(Hashtable<Integer, String> hm) {

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println();

	}

}
