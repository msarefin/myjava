package a_Practice;

public class OOPConcepts implements Ax {

	public static void main(String[] args) {
		System.out.println(msg);
	}

	@Override
	public void one() {
		// TODO Auto-generated method stub
		
	}
}

//Abstraction
//	Abstract Class 

class program {
	
	public program() {
		// TODO Auto-generated constructor stub
	}
	
	program(int m){
		System.out.println();
	}
}

//	Interface

interface Ax extends Ay{

	program p = new program();
	static final int n1 = 12; 

	void one();

}

interface Ay{
	static final String msg = "This is a static final string variable";
}