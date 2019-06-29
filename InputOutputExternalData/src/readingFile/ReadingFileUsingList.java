package readingFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFileUsingList {

	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt";
		
		List<String> text = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
		
		for(String s: text) {
			System.out.println(s);
		}
		
	}
	
}
