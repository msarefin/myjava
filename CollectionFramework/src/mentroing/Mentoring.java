package mentroing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Mentoring {

	public static void main(String[] args) {

		byte b;
		short s;
		int ii;
		long lg;
		double dd;

		char c;
		boolean bl;

		String st;

		int[] arr = { 2, 5, 6, 8, 3, 5 };

		int[] arr1 = new int[10];

		arr1[0] = 10;
		arr1[2] = 25;
		arr1[1] = 15;

		String[] days = new String[7];

		days[0] = "sfs";

		List<String> l = new ArrayList<String>();

		l.add("alex");
		l.add("james");
		l.add("jenny");
		l.add("alex");

		Iterator it = l.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println();

		for (String ar : l) {
			System.out.println(ar);
		}

		System.out.println();
		ListIterator<String> ls = l.listIterator(l.size());

		while (ls.hasPrevious()) {
			System.out.println(ls.previous());
		}

		System.out.println();

		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}

		System.out.println();

		for (int i = l.size() - 1; i >= 0; i--) {
			System.out.println(l.get(i));
		}

		System.out.println();

		l.forEach(a -> {
			System.out.println(a);
		});

		System.out.println();
		Iterator<String> itr = l.iterator();

		itr.forEachRemaining(a -> {
			System.out.println(a);
		});

		System.out.println("\n Array List non-generic \n");
		
		ArrayList aln = new ArrayList();

		aln.add("danny");
		aln.add("james");
		aln.add("Sam");
		aln.add("alex");
		aln.add(654654654);
		

		Iterator itn = aln.iterator(); 
		
		while(itn.hasNext()) {
			System.out.println(itn.next());
		}

		System.out.println("\n Array List generic \n");
		
		ArrayList<String> alg = new ArrayList<String>();
		
		alg.add("Ram");
		alg.add("vishnu");
		alg.add("hari");
		alg.add("ramesh");
		

		for (String list : alg) {

			System.out.println(list);
			
		}
		
		
		aln.addAll(alg);
		
		
		
		
		System.out.println(aln);
		
		

	}
}
