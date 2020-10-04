package a_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JustPractice {

	public static void main(String[] args) throws IOException {
		FileInputStream f = new FileInputStream("/Users/sunsh/Documents/JavaProject/EclipseProject/myjava/Practice/Files/Topics.txt");
		InputStreamReader isr = new InputStreamReader(f); 
		BufferedReader br = new BufferedReader(isr); 
		
		int c; 
		
		do { 
			c = br.read(); 
			System.out.print((char)c);
		}while( c !=-1);
		
		f.close();
		isr.close();
		br.close();

	}

}
