package a_Practice;



public class A{
	public static void main(String[] args) {
		B b = new B(); 
		B.car c =new B.car(); 
		c.alex();
	
		C cc = new C();
		cc.fromA();
		
		cc.new beta().fromBeta();
		cc.new gama().fromGama();
		cc.new theta().fromTheta();
		C.beta x = new C().new beta(); 
		
		System.out.println("Hello"+"\r World!!");
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
	
	protected static class car{
		protected void alex() {
			System.out.println("ALex says Hello !");
		}
	}
	
}
