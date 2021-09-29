package newPractice;

public class TryingPrintf {

	public static void main(String[] args) {
		System.out.printf("'%s'%n", "Name");
		System.out.printf("'%S'%n", "Name");
		System.out.printf("'%s'%n","***********Text"); 
		System.out.printf("'%1s'%n", "Text");
		System.out.printf("'%s'%n","Text***********"); 
		System.out.printf("'%-2s'%n", "Text");
		System.out.println("'****Te'");
		System.out.printf("'%-6.2s'%n", "Text");
		System.out.println("'Te****'");
		
		System.out.printf("%c%n",'a');
		System.out.printf("%C%n",'a');
		
		System.out.printf("%d%n",10000L);
		
	}
}
