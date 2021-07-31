package newPractice;

public class Practice {
	
	void hello() {
		System.out.println("Hello, Everyone!!!");
	}
	
	void greetings() {
		this.hello();
	}
	
	public static void main(String[] args) {
		new Practice().greetings();
		
	}
	
}