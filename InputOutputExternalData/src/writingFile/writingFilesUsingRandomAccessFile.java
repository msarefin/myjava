package writingFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.RandomAccess;

public class writingFilesUsingRandomAccessFile {

	public static void main(String[] args) throws IOException {
		RandomAccessFile writer = new RandomAccessFile(System.getProperty("user.name")+"/Files/text.txt", "rw");
	
		writer.seek(0);
		writer.writeInt(300);
		writer.close();
		
		
	
	}
}
