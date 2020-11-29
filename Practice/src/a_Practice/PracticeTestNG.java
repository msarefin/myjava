package a_Practice;

import java.util.Scanner;

import org.testng.Assert;



public class PracticeTestNG {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First number\n");
		int x = sc.nextInt();
		System.out.println("Enter second number\n");
		int y = sc.nextInt();
		System.out.println("Specify mathematical operation: 1 - Multiply, 2 - Add, 3 - Subtract, 4 - Divide\n");
		int z = sc.nextInt();

		int result = 0;
		switch (z) {
		case 1:
			result = x * y;
			Assert.assertEquals(mathematics.multiply(x, y), result);
			System.out.println("Multiply: "+ result);
			break;
		case 2:
			result = x+y;
			Assert.assertEquals(mathematics.add(x, y), result);
			System.out.println("add: "+ result);
			break;
		case 3:
			result = y-x; 
			Assert.assertEquals(mathematics.subtract(x, y), result);
			System.out.println("Subtract: "+ result);
			break;
		case 4:
			result = x/y; 
			Assert.assertEquals(mathematics.divide(x, y), result);
			System.out.println("Divide: "+ result);
			break; 

		default:
			System.err.println("Wrong Operation Selected!!");
			break;
		}
	}

}

class mathematics {

	static int multiply(int x, int y) {
		return x * y;
	}

	static int add(int x, int y) {
		return x + y;
	}

	static int subtract(int x, int y) {
		return x - y;
	}

	static int divide(int x, int y) {
		return x / y;
	}

}