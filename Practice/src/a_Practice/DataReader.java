package a_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DataReader {

	static FileReader fileReader = null; 
	static BufferedReader bufferedReader = null; 
		
	public static void main(String[] args) {
		String file = "/Users/sunsh/Documents/JavaProject/EclipseProject/myjava/Practice/Files/Topics.txt";
		
//		usingBufferReader(file);
//		usingFileReader(file);
//		usingScanner(file);
//		usingScannerNoWhile(file);
//		usingCollectionFramework(file);
		usingString(file);
		
		
	}
	
	static void usingString(String file) {
		try {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(file))); 
		
		System.out.println(data);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void usingCollectionFramework(String file) {
		
		List<String> lines = Collections.emptyList(); 
		try {
			lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Iterator<String> l = lines.iterator(); 
		while (l.hasNext()) {
			System.out.println(l.next());
		}
	}
	
	static void usingScannerNoWhile(String file) {
		
		try {
			File f = new File(file);
			Scanner sc = new Scanner(f);
			sc.useDelimiter("//Z");
			System.out.println(sc.next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		
				
	}
	
	static void usingScanner(String file) {
		try {
			File f = new File(file); 
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void usingFileReader(String file) {
		try {
			fileReader = new FileReader(file);
			
			int i;
			while((i = fileReader.read())!=-1) {
				System.out.print((char)i);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			}catch( IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static void usingBufferReader(String file) {
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader); 
			
			String data; 
			
			while((data = bufferedReader.readLine())!=null) {
				System.out.println(data);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new FileNotFoundException(); 
		}
		finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
