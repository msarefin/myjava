package writingFile;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WritingTextFile {

	public static void main(String[] args) throws IOException {
		String filePath = "C:/Users/sunsh/Documents/JavaProjects/myjava/InputOutputExternalData/Files";
		
		System.out.println(System.getProperty("user.dir"));
		
		FileWriter fw = new FileWriter(System.getProperty("user.dir")+"/Files/text.txt");
		
		String javaFile = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/readingFile/ReadingTextFile.java"))); 
		
		fw.write(javaFile);
		
		fw.close();
		
	}
}
