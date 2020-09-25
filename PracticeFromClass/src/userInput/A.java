package userInput;

public class A {

	A() {
		System.out.println("Default");
	}

	A(int a) {
		System.out.println("One int");
	}

	A(int a , String b) {
		System.out.println("int , string");
	}

	A(int a, String b , String  c) {
		System.out.println("int , stirng , string");
	}
	

	A( String b , int a, String  c) {
		System.out.println("String, int , String");
	}
	
	public static void main(String[] args) {
		new A(); 
		new A(12); 
		new A(12, "apple"); 
		new A(12, "Apple", "Orange"); 
		new A("Apple", 12, "Orange");
		
	}

}
