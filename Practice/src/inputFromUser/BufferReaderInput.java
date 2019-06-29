package inputFromUser;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderInput {

	public static void main(String[] args) throws IOException {
		System.out.println("what is your name ?");
		
		InputStreamReader in = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(in); 
		
		
		System.out.println("Hello, "+br.readLine());
		
		br.close();
		in.close();
	}
}
