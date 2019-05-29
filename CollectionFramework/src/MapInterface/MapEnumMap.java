package MapInterface;

import java.util.EnumMap;
import java.util.Map;

public class MapEnumMap {

	public static void main(String[] args) {

		EnumMap<month, String> map = new EnumMap<month, String>(month.class);

		map.put(month.JAN, "1");
		map.put(month.FEB, "2");
		map.put(month.MAR, "3");
		map.put(month.APR, "4");
		map.put(month.MAY, "5");
		map.put(month.JUN, "6");
		map.put(month.JUL, "7");
		map.put(month.AUG, "8");
		map.put(month.SEP, "9");
		map.put(month.OCT, "10");
		map.put(month.NOV, "11");
		map.put(month.DEC, "12");

		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

	}
}

enum month {
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
}