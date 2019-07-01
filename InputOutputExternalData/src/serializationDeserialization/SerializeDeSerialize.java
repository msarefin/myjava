package serializationDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeSerialize {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/Files/serialized.ser");
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeUTF("This is a text to serialize");

		out.close();
		fos.close();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/Files/serialized.ser");
		ObjectInputStream input = new ObjectInputStream(fis);

		String s = input.readUTF();

		System.out.println(s);

		input.close();
		fis.close();

	}
}
