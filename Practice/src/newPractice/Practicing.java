package newPractice;

public class Practicing {
	public static void main(String[] args) {
		single_ton s = single_ton.getConstructor();

		String str = new String("This was created using String object");

		String str1 = "This was created using string literal!";

		String s1 = "a";
		String s2 = "a";

		System.out.println(s1 == s2); // true - The string pool memory reference point in the heap is the same
		System.out.println(s1.equals(s2)); // true - The string value in the string pool in the heap is the same

		s2 = "b";
		System.out.println("*".repeat(10));
		System.out.println(s1 == s2); // false - The String pool memory reference point in the heap memory is
										// different
		System.out.println(s1.equals(s2)); // false - The String value in the string pool memory in heap is different

		System.out.println("String Object | ".repeat(10));

		String s3 = new String("a");

		System.out.println(s1 == s3); // False - The string pool reference is different because its a new object
		System.out.println(s1.equals(s3)); // True - The String value in the string pool in heap memory is the same

		s3 = "b";

		System.out.println("s1-s3 |".repeat(10));
		System.out.println(s1 == s3); // False - the string pool reference is different because its
		System.out.println(s1.equals(s3)); // False - the String value in the string pool memory in heap is different

		System.out.println("s2-s3 | ".repeat(10));
		System.out.println(s2 == s3); // True - The string pool reference is the same and refers to the same string
										// object
		System.out.println(s2.equals(s3)); // True - The string values in the string pool in heap memory refers to the
											// same object and hence are the same

		System.out.println("\n");
		String st = "String buffer and Sting Builder";
		System.out.println(st + "\n" + "=".repeat(st.length()) + "\n");

		StringBuffer sb = new StringBuffer("The Fish fingers are good!");
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(0);
		System.out.println(sb.capacity());
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());

		sb.append(2);

		System.out.println(sb);
		
		sb1.append("John"); 
		sb1.append("\nThis is the next line!");
		
		System.out.println(sb1.capacity());
		System.out.println(sb1);
		
		System.out.println(sb);
		sb.insert(21, "not ");
		System.out.println(sb);
		System.out.println(sb.length()); 

	}

	private void a() {
		System.out.println("This is A");
	}

	private void b() {
		this.a();
		System.out.println("This is B");
	}
}

class single_ton {
	static single_ton single;

	private single_ton() {
		System.out.println("Singleton class");
	}

	public static single_ton getConstructor() {
		if (single == null) {
			single = new single_ton();
		}

		return single;

	}
}