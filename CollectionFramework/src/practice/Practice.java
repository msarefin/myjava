package practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(1, "Math");
		map.put(2, "English");
		map.put(3, "Biology");
		map.put(4, "Chemistry");
		map.put(5, "Physics");
		map.put(6, "Computer Science");

		Set set = map.entrySet();
		
		Iterator it = set.iterator(); 
		
		while(it.hasNext()) {
			Map.Entry m = (Map.Entry)it.next(); 
			System.out.println(m.getKey()+" "+m.getValue());
		}
		
		System.out.println();
		
		Map<Integer,String> gmap = map; 
		
		for(Map.Entry m : gmap.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}

		
		System.out.println();
		
		gmap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
		
		
		
	}

}
