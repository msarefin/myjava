package readingFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileUsingFileReader {

	public static void main(String[] args) throws IOException {
		File file  = new File("C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt");
		
		FileReader fr = new FileReader(file);
		
		int c; 
		while((c = fr.read())!= -1) {
			System.out.print((char)c);
		}
	}
	
	
}
