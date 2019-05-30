package practice;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {

		Properties p = System.getProperties();
		Set set = p.entrySet();

		Iterator it = set.iterator();
		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
