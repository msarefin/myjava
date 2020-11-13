package readingFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileUingFileReaderBufferReader {

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		br.close();
		fr.close();

	}
}
