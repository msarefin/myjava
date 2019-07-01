package readingFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import userInput.BufferReaderInput;

public class ReadingTextFile {

	public static void main(String[] args) throws IOException {

		System.out.println("******************************\nUsing Scanner\n******************************");

		String fileLocation = "C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt";
		File file = new File(fileLocation);
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}

		sc.close();
		System.out.println("******************************\nUsing fileReader\n******************************");

		FileReader fr = new FileReader(file); 
		
		int n; 
		while((n = fr.read())!=-1) {
			System.out.print((char)n );
		}
		
		System.out.println("******************************\nUsing BufferReader\n******************************");

		fr = new FileReader(file); 
		BufferedReader br = new BufferedReader(fr);
		
		String output; 
		while((output = br.readLine())!=null) {
			System.out.println(output);
		}
		
		
		System.out.println("******************************\nUsing List\n******************************");
		
		java.util.List<String> textStream = Files.readAllLines(Paths.get(fileLocation), StandardCharsets.UTF_8);
		
		for(String s: textStream) {
			System.out.println(s);
		}
		
		System.out.println("******************************\nUsing String\n******************************");
		
		String data = new String(Files.readAllBytes(Paths.get(fileLocation)));
		
		System.out.println(data);
		
	}
}
