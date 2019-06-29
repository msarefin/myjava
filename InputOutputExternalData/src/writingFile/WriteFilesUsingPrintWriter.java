package writingFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFilesUsingPrintWriter {
	public static void main(String[] args) throws IOException {

		FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/Files/PrintWriter.txt");

		PrintWriter pw = new PrintWriter(fw); 
		pw.print("Print Writer\n");
		pw.printf("Product is %s and its price is %d $","iPhone", 1000 );
		
		
		pw.close();
		fw.close();
		
		System.out.println("Complete");
	}
}
