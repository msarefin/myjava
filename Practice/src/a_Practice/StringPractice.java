package a_Practice;

public class StringPractice {
	public static void main(String[] args) {
		StringPractice sp = new StringPractice(); 
		sp.reverseString("Sherlock Holmes");
	}

	static void palindromeCheck(String str) {
		boolean b = isPlaindrome(str);
		if (b == true) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not palindrome");
		}

	}

	private final static boolean isPlaindrome(String str) {
		str.toLowerCase();
		int f = 0;
		int l = str.length() - 1;
		while (f < l) {
			if (str.toLowerCase().charAt(f) != str.toLowerCase().charAt(l)) {
				return false;
			}
			f++;
			l--;
		}
		return true;
	}
	
	void reverseString(String str) { 
		char [] c = new char[str.length()];
		int j = 0;
		String output=""; 
		for(int i = str.length()-1; i>=0;i--) {
			c[j] =str.charAt(i);
			j++;
		}
		for(int i = 0 ; i< c.length;i++) {
			output = output+c[i];
		}
		System.out.println(output);
	}
}
