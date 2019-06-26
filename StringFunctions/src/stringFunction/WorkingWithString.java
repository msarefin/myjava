package stringFunction;

public class WorkingWithString {

	public static void main(String[] args) {

		WorkingWithString s = new WorkingWithString();

		String str = "Hello, I am a QA Tester. My role is to create Test Scenario based on Functional Requirements.";
		String str1 = "Then using the Test Scenario create TestCases ";

		int length = str.length();

		char charat = str.charAt(10);

		s.output(str);
		s.output(str.length());
		s.output(str.charAt(10));

		System.out.println(charat);

		s.output(str.substring(10));
		s.output(str.substring(0, 25));

		s.output(str.concat(str1));

		s.output(str.indexOf("QA"));

		s.output(str.indexOf('o', 13));

		s.output(str.lastIndexOf('a'));

		System.out.println(str.equals(str1));

		String msg = "Hello World";
		String msg1 = "HELLO WORLD";
		String msg2 = "                       hello world        !!                           ";

		System.out.println(msg.equals(msg1));
		System.out.println(msg.contentEquals(msg1));
		System.out.println(msg.equalsIgnoreCase(msg1));
		System.out.println(msg.equalsIgnoreCase(msg2));

		System.out.println(msg.compareTo(msg1));
		System.out.println(msg.compareToIgnoreCase(msg1));

		String msg3 = msg1.toLowerCase();
		System.out.println(msg3);
		System.out.println(msg.toUpperCase());
		
		
		s.output(msg2);
		
		s.output(msg2.trim());
		
		s.output(str.replace('o', 'w'));
		
		
		
		StringBuffer sb = new StringBuffer("This is done usingString Buffer!");
		
		s.output(sb.toString());
		
		
		s.output(sb.insert(4, " Sentence ").toString());
		
		s.output(sb.toString());
		
		sb.insert(sb.lastIndexOf("!")+1, true);
		s.output(sb.toString());
		
		
		sb.insert(5,425.34d );
		
		s.output(sb.toString());
				
		
		char [] characters = {'h','e','l','l','o'};
		
		
		sb.insert(12, characters); 
		
		System.out.println(sb.toString());


		StringBuilder sbld = new StringBuilder("This is Sting builder");
		
		
		sbld.insert(8, " done using string ");
		
	
		s.output(sbld.toString());
		
		
	}

	void output(String str) {
		System.out.println(str);
	}

	void output(int num) {
		System.out.println(num);
	}

}
