package mathematics;

public class Fibunacci {

	public static void main(String[] args) {
		fibu(10);
	}

	static void fibu(int i) {
		int count =0 ; 
		int n = 0;
		int m = 1;
		int r = 0;

		do {
			r = n + m;
			System.out.println(r);
			n = m;
			m = r;

			count++;
		} while (count < i);

	}
}
