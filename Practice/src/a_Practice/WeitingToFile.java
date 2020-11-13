package a_Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WeitingToFile {

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir") + "/Created Files");
//		System.out.println(file.toString());
		CreateDirectory(file);
		String source = System.getProperty("user.dir")+"/Files/Topics.txt";
		usingFileWriter(source, file);

	}
	
	static void usingFileWriter(String source, File file) { 
		try {
			FileWriter fileWriter = new FileWriter(file.toString()+"/Written using file writer.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter); 
			printWriter.print(new String(Files.readAllBytes(Paths.get(source))));
			
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	static void CreateDirectory(File file) {
		deleteFolder(file);
		boolean b = file.mkdirs();
		if (b) {
			System.out.println("Created : " + file.toString());
		}
	}

	static void deleteFolder(File file) {
		if (!file.exists()) {
			return;
		} else {
			for (File subFile : file.listFiles()) {
				if (subFile.isDirectory()) {
					deleteFolder(subFile);
				} else {
					subFile.delete();
				}
			}
			file.delete();
		}
	}
}
