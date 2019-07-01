package writingFile;

//import org.testng.Assert;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WritingFilesUsingDataOutputStream {

	private static final String DataOutout = null;

	public static void main(String[] args) throws IOException {
		String str = "Created with DataOutputStream";

		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/Files/DataOutputStream.txt");

		DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

		outStream.writeUTF(str);
		outStream.close();

//		verify  
		String result;
		FileInputStream fis = new FileInputStream(System.clearProperty("user.dir") + "/File/DataOutputStream.txt");
		DataInputStream reader = new DataInputStream(fis);
		result = reader.readUTF();
		reader.close();
		
		

	}
}
