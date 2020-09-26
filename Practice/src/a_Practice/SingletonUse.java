package a_Practice;

public class SingletonUse {

	public static void main(String[] args) {
		singleton sing = singleton.getInstance(); 
	}
}

class singleton{
	
	private static singleton instance = new singleton(); 
	
	private singleton() {
		
	}
	
	public static singleton getInstance() {
		return instance; 
	}
}
