package a_Practice;

public class PracticeExceptions {

	public static void main(String[] args) throws Exception {
		div(12, 0);
//		divide(12, 0);
		
	}

	static void div(double n, double d){
		try {
			int  result = ((int)n /(int) d);
			System.out.println("The Result is : " + result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			throw new ArithmeticException("You cannot Divide by Zero");

			
			
		}finally {
			System.out.println("Calculation Completed!!");
		}
		
		System.out.println("This message doesnt appear!");
		
	}
	
	static void divide (int n, int d) throws ArithmeticException{
		int  result = ((int)n /(int) d);
		System.out.println("The Result is : " + result);
	}

}
