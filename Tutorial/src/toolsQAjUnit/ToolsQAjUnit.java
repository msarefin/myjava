package toolsQAjUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.testng.annotations.AfterMethod;



public class ToolsQAjUnit {
	MathProvider provider;

	public ToolsQAjUnit() {
		provider = new MathProvider();
	}

	@Test
	public void add() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		int firstNumber = 10;
		int secondNumber = 20;
		assertEquals(firstNumber + secondNumber, provider.Add(firstNumber, secondNumber));
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println("-".repeat(15));
	}

    @Test
	public void subtract()
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	    int firstNumber = 10;
	    int secondNumber = 20;
		assertEquals(firstNumber + secondNumber, provider.Substract(firstNumber, secondNumber));
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
}

class MathProvider {

	public MathProvider() {
	}

	public int Substract(int firstNumber, int secondNumber) {
		return (firstNumber - secondNumber);
	}

	public int Add(int firstNumber, int secondNumber) {
		return (firstNumber + secondNumber);
	}

	public int Multiply(int firstNumber, int secondNumber) {
		return (firstNumber * secondNumber);
	}

}