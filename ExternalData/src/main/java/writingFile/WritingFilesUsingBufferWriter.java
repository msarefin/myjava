package writingFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WritingFilesUsingBufferWriter {

	public static void main(String[] args) throws IOException {
		String str = "Buffer Writer";

		FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/Files/BufferWriter.txt");

		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(str);

		bw.append(' ');
		bw.append(" using append");
		bw.close();
		fw.close();

	}
}
