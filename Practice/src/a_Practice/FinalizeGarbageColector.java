package a_Practice;

public class FinalizeGarbageColector {

	public static void main(String[] args) {
		FinalizeGarbageColector g1 = new FinalizeGarbageColector(); 
		FinalizeGarbageColector g2 = new FinalizeGarbageColector(); 
		
		g1 = null; 
		g2 = null; 
		
		System.gc();
	}
	
	public void finalize() {
		System.out.println("Called Fianlize method!!!");
	}
	
}
