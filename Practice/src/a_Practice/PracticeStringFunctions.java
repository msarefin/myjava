package a_Practice;

import java.util.Arrays;

public class PracticeStringFunctions {
	public static void main(String[] args) {
		new anagram("cat");

//		anagram("cat");
	}

	private static void anagram(String word) {
		char c[] = new char[word.length()];

		for (int i = 0; i < c.length; i++) {
			c[i] = word.charAt(i);
		}
		System.out.println(Arrays.toString(c));

	}
	
	
	
	

}

class anagram {
	static int size;
	static int count;
	static char[] arrChar = null;

	anagram(String word) {

		String input = word;
		size = input.length(); 
		arrChar = new char[size + 1];
		for (int j = 0; j < size; j++)
			arrChar[j] = input.charAt(j);
		doAnagram(size);
	}

	static void doAnagram(int newSize) {
		System.out.println("new Size="+newSize);
		if (newSize == 1) {
			System.out.println(newSize+"=="+1+"--> get out of the loop and get back to previous recursion\n"+"^".repeat(100));
			return;
		}
		for (int j = 0; j < newSize; j++) {
			System.out.println(j+"<"+newSize);
			doAnagram(newSize - 1);
			System.out.println("Bcak to Previoues recursion: new Size = "+newSize);
			if (newSize == 2) {
				System.out.println(newSize+"=="+2+"--> Display Word");
				displayWord();
			}
			rotate(newSize);
		}
		System.out.println("end of line -> back to Previoues recursion: new Size = "+newSize);
	}

	static void rotate(int newSize) { 
		int j;
		int position = size - newSize; 
		char temp = arrChar[position];
		for (j = position + 1; j < size; j++)
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp;

	}

	static void displayWord() {
		for (int j = 0; j < size; j++) {
			System.out.print(arrChar[j]);
		}
		System.out.println("\n"+"-".repeat(10));
	}

}