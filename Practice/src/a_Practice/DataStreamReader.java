package a_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataStreamReader {
	public static void main(String[] args) throws IOException {

		readingUsingInputStream();
	}

	static void readingUsingInputStream() throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		String n = "";

		System.out.println("Please enter you name: ");
		while (!n.equalsIgnoreCase("Stop")) {
			n = br.readLine().trim();

			if (n.isBlank()) {
				System.out.println("\nTo Stop the program enter \"Stop\"");
			} else if (n.equalsIgnoreCase("stop")) {

			} else {
				System.out.println("Hello, " + n);
			}
		}

		System.out.println("Process Ended Successfully!");
	}
	
	
	
}
