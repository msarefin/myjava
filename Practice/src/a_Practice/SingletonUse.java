package a_Practice;

public class SingletonUse {

	public static void main(String[] args) {
		singleton sing = singleton.getInstance(); 
		singleton dbConnect = singleton.MyConnection("MyDB");
		
		singleton sing1 = singleton.getInstance(); 
		
		System.out.println(sing.hashCode());
		System.out.println(sing1.hashCode());
	}
}

class singleton{
	
	private static singleton instance = new singleton(); 
	
	private singleton() {
		
	}
	
	private singleton(String msg) {
		connection(msg);
	}
	
	private void connection(String connection) {
		System.out.println("Connection to : "+connection);
	}
	
	public static singleton MyConnection(String n) {
		return new singleton(n);
	}
	
	public static singleton getInstance() {
		return instance; 
	}
}
