package MapInterface;

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
		
		for(Map.Entry m : gMap.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
	
		
		
		
	}
}
