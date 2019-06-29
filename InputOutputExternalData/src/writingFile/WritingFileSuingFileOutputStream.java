package writingFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WritingFileSuingFileOutputStream {

	public static void main(String[] args) throws IOException {
		String str = " Created with FileOutputStream";

		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/Files/FileOutputStream.txt");
		byte[] strToBytes = str.getBytes();
		fos.write(strToBytes);

		fos.close();

		
	}
}
