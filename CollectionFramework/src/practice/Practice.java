package practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {

		Map map = new HashMap(); 
		
	
		map.put(1,"Alex");
		map.put(2, "James"); 
		map.put(3,"Ali");
		map.put(4,"Joanne");
		map.put(5,"Jenny");
		
		
		Set set = map.entrySet(); 
		
		System.out.println(set);
		
		Iterator it = set.iterator(); 
		

		while(it.hasNext()) {
			Map.Entry m = (Map.Entry)it.next();
			System.out.println(m.getKey()+" | "+m.getValue());
			
		}
	
		Map<Integer, String> gmap = map; 
		
		Set gSet = gmap.entrySet(); 
		
		Iterator gIt = gSet.iterator(); 
		
		System.out.println();
	
		while(gIt.hasNext()) {
			Map.Entry me = (Map.Entry)gIt.next(); 
			
			System.out.println(me.getKey()+" "+me.getValue());
		}
		
		System.out.println();
		
		for(Map.Entry e: gmap.entrySet()) {
			System.out.println(e.getKey()+"::"+e.getValue());
		}
		
	}

}
