package newPractice;

public class Practicing {
	public static void main(String[] args) {
		single_ton s = single_ton.getConstructor(); 
	}

	private void a() {
		System.out.println("This is A");
	}

	private void b() {
		this.a();
		System.out.println("This is B");
	}
}

class single_ton {
	static single_ton single ;

	private single_ton() {
		System.out.println("Singleton class");
	}
	
	public static single_ton getConstructor() {
		if(single == null ) {
			single = new single_ton(); 
		}
		
		return single;
		
	}
}