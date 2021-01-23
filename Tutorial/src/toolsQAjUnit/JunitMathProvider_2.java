package toolsQAjUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class JunitMathProvider_2 {

	MathProvider provider;	

	public JunitMathProvider_2(){
		System.out.println("JunitMathProvider_2\n"+"=".repeat(20));
		provider = new MathProvider();
	};

	@Test
	public void multiply()
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	    int firstNumber = 10;
	    int secondNumber = 20;
		assertEquals(firstNumber * secondNumber, provider.Multiply(firstNumber, secondNumber));
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

}
