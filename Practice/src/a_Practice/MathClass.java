package a_Practice;

public class MathClass {
	public static void main(String[] args) {
		MathClass mc = new MathClass();
//		mc.nthFibunacci(15);
		mc.isEven(12);
		mc.nPrime(100);
		mc.triangleNumber(100);
		mc.factorial(20);
		mc.palindromeCheck("dead");
	}

	static void palindromeCheck(String str) {
		boolean b = isPlaindrome(str);
		if (b == true) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not palindrome");
		}

	}

	private final static boolean isPlaindrome(String str) {
		str.toLowerCase();
		int f = 0;
		int l = str.length() - 1;
		while (f < l) {
			if (str.toLowerCase().charAt(f) != str.toLowerCase().charAt(l)) {
				return false;
			}
			f++;
			l--;
		}
		return true;
	}

	void nthFibunacci(int n) {

		int fn = 0;
		int sn = 1;
		int c = 0;
		int sum = 0;
		while (c < n) {
			c++;
			System.out.println(c + ":" + fn);
			sum = fn + sn;
			fn = sn;
			sn = sum;
		}
	}

	void isEven(int n) {
		if (n % 2 == 0) {
			System.out.println(n + " is Even!");
		} else {
			System.out.println(n + " is Odd!");
		}
	}

	void nPrime(int n) {
		int i = 0;
		int c = 0;
		while (c < n) {
			if (isPrime(i)) {
				c++;
				System.out.println(c + " : " + i);
			}
			i++;
		}

//		for(int i= 0; i< n; i++) { 
//			while(isPrime(i)) { 
//				System.out.println(i);
//				break; 
//			}
//		}
	}

	private static boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

//		if (n <= 1) {
//			return false;
//		}
//		for (int i = 2; i <= n / 2; i++) {
//			if (n % i == 0) {
//				return false;
//			}
//		}
//		return true;

	}

	void triangleNumber(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			sum = sum + i;
			System.out.println(sum);
		}
	}

	void factorial(int n) {
		if (n == 0) {
			System.out.println(1);
		}
		if (n > 0) {
			long p = 1;
			for (int i = 1; i < n; i++) {
				p = p * i;
				System.out.println(p);
			}
		}
	}
}
