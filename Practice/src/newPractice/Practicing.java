package newPractice;

public class Practicing {
	static A a = new A();
	public static void main(String[] args) {
		
	}
	
	
}

class A extends B{ 
	A(){
		super(); 
		super.beta();
	}

	
}

class B extends C{
	B(){
		super();
		this.beta();
	}
	
	void beta() {
		System.out.println("This is from B beta!");
		
	}
	
	private void delta() {
		System.out.println(" This is from DElta ");
	}
}

class C{
	C(){
		System.out.println("This is from C");	
	}
}