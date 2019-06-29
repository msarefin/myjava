package readingFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class RadingFileUsingScanner {

	public static void main(String[] args) throws IOException {
		String fileLocation = "C:/Users/sunsh/Documents/JavaProjects/myjava/Practice/Files/Topics.txt";
		File file = new File(fileLocation);
		Scanner sc;
		
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		
			List<String> stream = Files.readAllLines(Paths.get(fileLocation), StandardCharsets.UTF_8);
			

			System.out.println(stream);
			
			
			for(String s : stream) {
				System.out.println(s);
			}
			
	}
}
