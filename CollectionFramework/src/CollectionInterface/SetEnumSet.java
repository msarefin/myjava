package CollectionInterface;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class SetEnumSet {

	public static void main(String[] args) {
		Set<days> set = EnumSet.of(days.TUESDAY, days.FRIDAY);

		Set<days> set1 = EnumSet.allOf(days.class);
		Set<days> set2 = EnumSet.noneOf(days.class);

		Iterator<days> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println(set1);
		System.out.println(set2);

	}
}

enum days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}