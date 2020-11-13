package a_Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class JustPractice {
	public static void main(String[] args) {

		try {
			Path path = Paths.get(System.getProperty("user.dir")+"/Created Files/");
			Files.createDirectories(path);
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/Created Files/Written.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.print("Text written using PrintWriter\n");
			pw.printf("%s cost %d", "ALM Software", 25000);

			pw.close();
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
