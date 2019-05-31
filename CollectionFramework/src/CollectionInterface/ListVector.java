package CollectionInterface;

import java.util.Enumeration;
import java.util.Vector;

public class ListVector {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("Umesh");
		v.addElement("Irfan");
		v.addElement("Kimar");

		Enumeration e = v.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}
}
