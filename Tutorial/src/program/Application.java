package program;

public class Application {

	public static void main(String[] args) {
		// Main method

//		System.out.println("Prime Number Finder:");
//
//		int r = 1000;
//		int counter = 0;
//		for (int i = 0; i <= r; i++) {
//			boolean b = isPrime(i);
//			if (b == true) {
//				counter++;
//				System.out.println(counter + " : " + i);
//			}
//		}
//		System.out.println("Number of prime numbers between 1 and " + r + " : \n" + counter);

//		permutation("and");

//		System.out.println(isPrime(91));
		
		int  f= fib(7);
		
		System.out.println(f);
		

	}

	static void permutation(String str) {
		permutation(str, "");
	}

	static int level = 0;

	static void permutation(String str, String prefix) {
		System.out.println("Level=" + ++level);
		System.out.println("String length=" + str.length());
		if (str.length() == 0) {
			System.out.println("str: " + str + "\t prefix: " + prefix);
			System.out.println("Permut: " + prefix);
		} else {
			System.out.println("str: " + str + "\t prefix: " + prefix);
			for (int i = 0; i < str.length(); i++) {

				System.out.println("i=" + i);
				String rem = str.substring(0, i) + str.substring(i + 1);
				System.out.println("rem: " + rem + "\t prefix: " + prefix + str.charAt(i));
				permutation(rem, prefix + str.charAt(i));
				System.out.println("level=" + --level);
			}
		}
	}

	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		} else {
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					System.out.println("i : " + i);
					return false;
				}
			}
		}
		return true;
	}
	
	static int c = 0;
	static int fib(int n){
		System.out.println(++c);
	    if(n<=0) return 0;
	    else if(n==1) return 1;
	    return fib(n-1)+fib(n-2);
	}

}
