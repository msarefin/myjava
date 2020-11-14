package a_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializeAndDeserialize {

	public static void main(String[] args) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/Serialization Deserialization");
		file.mkdirs();

		String location = file.toString() + "/seialized.ser";

		FileOutputStream fos = new FileOutputStream(location);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeUTF(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/Files/Topics.txt"))));

		out.close();
		fos.close();

		FileInputStream fis = new FileInputStream(location);
		ObjectInputStream input = new ObjectInputStream(fis);

		String s = input.readUTF();
		String msg = "This is From Serialized file";
		System.out.println(msg+"\n"+"=".repeat(msg.length()));
		System.out.println(s);

		input.close();
		fis.close();

	}

}
