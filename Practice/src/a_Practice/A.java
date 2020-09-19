package a_Practice;

public class A{
	public static void main(String[] args) {
		B b = new B(); 
	}
}

class B {

	{
		System.out.println("This is a non static block");
	}
	
	static {
		System.out.println("This is a Static block");
	}

	B(){
		System.out.println("This is a Constructor!");
	}
	
	void myMethod() {
		System.out.println("Non static method");
	}
	
	static void myMethod1() {
		System.out.println("Static Method");
	}
	
}
