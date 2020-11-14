package a_Practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingToFile {

	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir") + "/Created Files");
//		System.out.println(file.toString());
		CreateDirectory(file);
		String source = System.getProperty("user.dir") + "/Files/Topics.txt";
		usingFileWriter(source, file);
		usingFileOutputStream(source, file);
		usingFileReaderBufferReader(source, file);
		usingRandomAccessFile(source, file);

//		RandomAccessFile ra;
//		try {
//			StringBuffer buffer = new StringBuffer();
//			ra = new RandomAccessFile(source, "r");
//			while (ra.getFilePointer() < ra.length()) {
//				buffer.append(ra.readLine() + System.lineSeparator());
//				
//			}
//			String content = buffer.toString();
//			System.out.println(content);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	static void usingRandomAccessFile(String source ,File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file.toString()+"/Random Access File.txt", "rw");
			raf.seek(0);
			raf.write(65);
			raf.writeInt(65);
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void usingFileReaderBufferReader(String source, File file) {
		try {
			FileWriter fw = new FileWriter(file.toString() + "/usning File Reader and BufferReader.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("File reader BufferReader\n");
			bw.append(new String(Files.readAllBytes(Paths.get(source))));
			bw.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void usingFileOutputStream(String source, File file) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					file.toString() + "/Created using fileoutput stream.txt");
			byte[] strToByte = new String(Files.readAllBytes(Paths.get(source))).getBytes();
			fileOutputStream.write(strToByte);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void usingFileWriter(String source, File file) {
		try {
			FileWriter fileWriter = new FileWriter(file.toString() + "/Written using file writer.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.printf("%s Costs %d dollars monthly", "Rent", 1000);
			printWriter.print(new String(Files.readAllBytes(Paths.get(source))));

			printWriter.flush();
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
