package a_Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeCSVFileReader {

	public static void main(String[] args) {
		
		String line = "";
		String SplitBy = ",";
		List roster = new ArrayList(); 
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/Files/rosterCodeLab1_15_2020.csv"));
			while((line = br.readLine())!=null) {
				String [] students = line.split(SplitBy); 
				
				System.out.println(Arrays.toString(students));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
