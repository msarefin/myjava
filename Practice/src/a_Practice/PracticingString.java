package a_Practice;

public class PracticingString {

	static String msg = "When you have eleminated the impossible what remains however imporbable must be the truth !";
	
	public static void main(String[] args) {
		int n = msg.length(); 
		System.out.println("Length of the string : "+ n);
		System.out.println(msg.charAt(5));
		System.out.println(msg.equalsIgnoreCase("truth"));
		System.out.println(msg.equals(msg));
		System.out.println(msg);
		System.out.println(msg.substring(12));
		System.out.println(msg.substring(5, msg.length()));
		System.out.println();
	}
}
