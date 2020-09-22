package a_Practice;

public class C {

	String n = "This is from class C ";
	
	
	
	public void fromA() {
//		C.alpha ca = new C().new alpha();

//		ca.systeminfo();
		
		C c = new C(); 
		C.alpha a = new C().new alpha(); 
		C.beta b = new C().new beta(); 
		C.gama g = new C().new gama(); 
		C.theta t = new C().new theta();
		
		 a.systeminfo();
		 b.fromBeta();
		 g.fromGama();
		 t.fromTheta();
		
	}

//	private class
	private class alpha {
		String an = "This is from alpha";
		public void systeminfo() {
			System.out.println(System.getProperty("os.name"));
		}
	}

//	default class
	class beta {
		String ab = "This is from beta";
		public void fromBeta() {
			System.out.println("From beta");
		}
	}

//	protected class
	protected class gama {
		String ag = "This is from gama"; 
		public gama() {
			// TODO Auto-generated constructor stub
			System.out.println("class gama has a user denined constructor");
		}

		public void fromGama() {
			System.out.println("from gama");
		}
	}

//	public class
	public class theta {
		public void fromTheta() {
			System.out.println("From Theta");
		}
	}
}
