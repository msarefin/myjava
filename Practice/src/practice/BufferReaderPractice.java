package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderPractice {

	
	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		
		
		String msg = br.readLine(); 
		
		System.out.println(msg);
		
		br.close();
		
	}
	
}
