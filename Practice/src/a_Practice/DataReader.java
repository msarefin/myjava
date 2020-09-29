package a_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

	static FileReader fileReader = null; 
	static BufferedReader bufferedReader = null; 
		
	public static void main(String[] args) {
		String file = "/Users/sunsh/Documents/JavaProject/EclipseProject/myjava/Practice/Files/Topics.txt";
		
		usingBufferReader(file);
		usingFileReader(file);
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
