package a_Practice;

import java.nio.charset.Charset;

public class JustPractice {

	public static void main(String[] args) {
		byte a[] = {71, 101, 101, 107, 115};
		
		String s = new String(a, Charset.defaultCharset());
		
		System.out.println(s);
	}

}
