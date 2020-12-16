package a_Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PracticeStringFunctions {
	public static void main(String[] args) {
//		new anagram("bob");
//		String sentence = "Human brain is a biological learning machine";
//		new longestWordInSentence(sentence);
		String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
//		new duplicateWords(st);
		String b = "bob";
		new permutation().permut(b);

//		for (int i = 0; i < b.length(); i++) {
//			System.out.println(b.substring(i + 1, b.length()));
//		}
	}

}

class permutation {

	public static void permut(String str) {
		if (str.length() == 0 || str == null) {
			return;
		} else if (str.length() == 1) {
			System.out.println(str);
			return;
		} else {
			perm("", str);
		}
	}

	public static void perm(String prefix, String remaining) {
		if (remaining.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < remaining.length(); i++) {
				perm(prefix + remaining.charAt(i),
						remaining.substring(0, i) + remaining.substring(i + 1, remaining.length()));
			}
		}
	}
}

class duplicateWords {
	public duplicateWords(String sentence) {
		String cSentece = sentence.toLowerCase().replaceAll("[\\W]", " ");
		String[] words = cSentece.split(" ");
		Map<String, Integer> duplicate = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals("")) {

			} else {
				int counter = 1;
				duplicate.put(words[i], counter);
				for (int j = i + 1; j < words.length; j++) {
					if (words[i].equalsIgnoreCase(words[j])) {
						counter++;
						words[j] = "";
					}
				}
				duplicate.put(words[i], counter);
				words[i] = "";
			}
		}
		for (Entry<String, Integer> m : duplicate.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}

	}
}

class longestWordInSentence {
	public longestWordInSentence(String sentence) {
		String s = sentence.replaceAll("[\\W]", " ");
		String[] words = s.split(" ");

		System.out.println(Arrays.toString(words));

		int max = 0;
		String longest = "";
		for (String w : words) {
			if (max < w.length()) {
				max = w.length();
				longest = w;
			}
		}

		System.out.println(longest + "->" + max);

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
		if (newSize == 1) {
			return;
		}
		for (int j = 0; j < newSize; j++) {
			doAnagram(newSize - 1);
			if (newSize == 2) {
				displayWord();
			}
			rotate(newSize);
		}
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
		System.out.println();
	}

}