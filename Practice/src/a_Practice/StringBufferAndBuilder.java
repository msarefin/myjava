package a_Practice;

public class StringBufferAndBuilder {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("When you heve eleminated the in impossible"); 
		
		String n = new String("This is just a very good text");
		System.out.println(n.hashCode());
		n.concat(", but it is not as good as this one!!!");
		System.out.println(n.hashCode());
		n.replace(n, "This is the new text !!");
		n = "Hello !!!";
		System.out.println(n.hashCode());
		
		
		System.out.println(sb.hashCode());
		
		sb.append(", what remains however imporbable must be the truth !!!");
		sb.insert(12, "RANDOM TEXT");
		System.out.println(sb.hashCode());
		
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		sb.delete(12, sb.length());
		System.out.println(sb.hashCode());
	}
	
}
