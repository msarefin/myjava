package a_Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class JustPractice {
	public static void main(String[] args) throws FileNotFoundException {

		String pathname = "C:/Users/sunsh/Documents/JavaProject/EclipseProject/myjava/Practice/Files/Topics.txt";
		
		new externalDataSource().readFileUsingScanner(pathname);
		
		
	}

	static class externalDataSource{
		void readFileUsingScanner(String pathname) {
			File file = new File(pathname);
			try {
				Scanner sc = new Scanner(file);
				while(sc.hasNext()) { 
					System.out.println(sc.nextLine());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			System.out.println("\n The lines are divided into a List of array \n");
			
			try {
				List<String> stream = Files.readAllLines(Paths.get(pathname));
				System.out.println(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
