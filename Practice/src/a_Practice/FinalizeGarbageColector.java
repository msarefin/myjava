package a_Practice;

public class FinalizeGarbageColector {

	public static void main(String[] args) {

		try {

			FinalizeGarbageColector g1 = new FinalizeGarbageColector();
			FinalizeGarbageColector g2 = new FinalizeGarbageColector();

			g1 = null;
//			g2 = null;

			g1.justAMethod();
			g2.justAMethod();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"The method cannot be called using the referance variable because it is reinitialized as null!");

		} finally {

			System.gc();
		}

	}

	void justAMethod() {
		System.out.println("Just a method!");
	}

	public void finalize() {
		System.out.println("Called Fianlize method!!!");
	}

}
