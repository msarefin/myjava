package designPattern;

public class singletonPattern {

	public static void main(String[] args) {

		singleton s = singleton.getInstance();
		s.method();
	}
}

class singleton {

	private static singleton sg = new singleton();

	private singleton() {

	}

	public static singleton getInstance() {
		return sg;
	}

	public void method() {
		System.out.println("Method from singleton class");
	}

}
