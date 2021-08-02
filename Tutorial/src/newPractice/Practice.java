package newPractice;

public class Practice extends parent {
	
	String n = super.gender("man"); 

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

class parent implements human{
	
	    parent(){
		eyes("hazel");
		ears();
		nose("pointy");
		System.out.println(name("Adam"));
	}
	
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

	@Override
	public void eyes(String n ) {
		// TODO Auto-generated method stub
		System.out.println("My eyes are "+n);
	}

	@Override
	public void ears() {
		// TODO Auto-generated method stub
		System.out.println("My ears are small!");
	}

	@Override
	public void nose(String n) {
		// TODO Auto-generated method stub
		System.out.println("My nose is "+ n );
	}

	@Override
	public String name(String name) {
		// TODO Auto-generated method stub
		return "My name is "+name;
	}
}

interface human{
	void eyes(String eyes);
	void ears(); 
	void nose(String nose); 
	String name(String name);
}