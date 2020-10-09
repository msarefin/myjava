package a_Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JustPractice {

	public static void main(String[] args) throws IOException {
		System.out.println("Mutable and Immutable Object Example");
		
	}

}

class Mutable{
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}  

	public Mutable (int value) { 
		this.value = value; 
		
	}
}

class Immutable{ 
	private final int value;

	public int getValue() {
		return value;
	}

	public int settValue(int value) {
		this.value = value; 
	}
	
	public Immutable(int value ) {
		this.value = value; 
	}
	
}