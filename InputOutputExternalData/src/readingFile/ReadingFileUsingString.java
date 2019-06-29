package readingFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadingFileUsingString {

	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt";
		
		String Data = new String(Files.readAllBytes(Paths.get(filePath))); 
		
		System.out.println(Data);
	}
	
}
