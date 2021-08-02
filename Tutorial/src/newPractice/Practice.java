package newPractice;

public class Practice extends parent {
	
	String n = super.gender("sagk"); 

	void hello() {
		System.out.println("Hello, Everyone!!!");
	}

	void greetings() {
		this.hello();
	}

	public static void main(String[] args) {
		new Practice().greetings();
		System.out.println(new Practice().n);
	}

}

class parent {
	String gender(String g) {
		String msg = "";
		
		if(g.equals("female") || g.equals("woman")) {
			msg =  "I am a Mother";
		}else if (g.equals("male")|| g.equals("man")) {
			msg =  "I am a Father";
		}else {
		msg = "Choose either between man and woman or male and female";
		}
		
		return msg; 
	}
}