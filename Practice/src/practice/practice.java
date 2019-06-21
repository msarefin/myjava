package practice;

public class practice {

	public static void main(String[] args) {
		outerClass outer = new outerClass();

		outer.publicOuterMethod();
		outer.protectedOuterMethod();
		outer.defaultOuterMethod();

		outer.innerB.publicInnerMethodB();
		outer.innerB.protectedInnerMethodB();
		outer.innerB.defaultInnerMethodB();

		outer.innerC.publicInnerMethodC();
		outer.innerC.protectedInnerMethodC();
		outer.innerC.defaultInnerMethodC();

		outer.innerE.publicInnerMethodE();
		outer.innerE.protectedInnerMethodE();
		outer.innerE.defaultInnerMethodE();

		outerClass.publicInnerClassB b = new outerClass().new publicInnerClassB();
		outerClass.publicInnerClassB b1 = outer.new publicInnerClassB();

		b.publicInnerMethodB();
		b.defaultInnerMethodB();
		b.protectedInnerMethodB();

		b1.publicInnerMethodB();
		b1.defaultInnerMethodB();
		b1.protectedInnerMethodB();

		outerClass.defaultInnerClassC c = new outerClass().new defaultInnerClassC();
		outerClass.defaultInnerClassC c1 = outer.new defaultInnerClassC();

		c.publicInnerMethodC();
		c.protectedInnerMethodC();
		c.defaultInnerMethodC();

		c1.publicInnerMethodC();
		c1.protectedInnerMethodC();
		c1.defaultInnerMethodC();

		outerClass.staticDefaultInnerClassD.publicInnerMethodC();
		outerClass.staticDefaultInnerClassD.defaultInnerMethodC();
		outerClass.staticDefaultInnerClassD.protectedInnerMethodC();

		outerClass.protectedInnerClassE e = new outerClass().new protectedInnerClassE();
		outerClass.protectedInnerClassE e1 = outer.new protectedInnerClassE();

		e.publicInnerMethodE();
		e.protectedInnerMethodE();
		e.defaultInnerMethodE();
		
		e1.publicInnerMethodE();
		e1.protectedInnerMethodE();
		e1.defaultInnerMethodE();

	}
}

class outerClass {
	privateInnerClassA innerA = new privateInnerClassA();
	defaultInnerClassC innerC = new defaultInnerClassC();
	publicInnerClassB innerB = new publicInnerClassB();
	protectedInnerClassE innerE = new protectedInnerClassE();

	public void publicOuterMethod() {
		System.out.println("This is public outer method from outer class");

		innerA.publicInnerMethodA();
//		innerA.defaultInnerMethodA();
//		innerA.protectedInnerMethodA();
//		innerA.privateInnerMethodA();

	}

	void defaultOuterMethod() {
		System.out.println("This is default outer method from outer class");
	}

	protected void protectedOuterMethod() {
		System.out.println("This is protected outer method from outer class");
	}

	private void privateOuterMethod() {
		System.out.println("This is a private outer method from outer class");
	}

//	-----------------------------------------------Inner Class-------------------------------------------------------

	private class privateInnerClassA { // Methods within private inner class can only be accessed by other classes by
		// creating instance of the class in the outer class

		public void publicInnerMethodA() {
			System.out.println("This is publicInnerMethodA from privateInnerClassA");
		}

		void defaultInnerMethodA() {
			System.out.println("This is defaultInnerMethodA from privateInnerClassA");
		}

		protected void protectedInnerMethodA() {
			System.out.println("This is protectedInnerMethodA from privateInnerClassA");
		}

		private void privateInnerMethodA() {
			System.out.println("This is privateInnerMethodA from privateInnerClassA");
		}

	}

	public class publicInnerClassB {

		public void publicInnerMethodB() {
			System.out.println("This is publicInnerMethodB from publicInnerClassB");
		}

		void defaultInnerMethodB() {
			System.out.println("This is defaultInnerMethodB from publicInnerClassB");
		}

		protected void protectedInnerMethodB() {
			System.out.println("This is protectedInnerMethodB from publicInnerClassB");
		}

		private void privateInnerMethodB() {
			System.out.println("This is privateInnerMethodB from publicInnerClassB");
		}
	}

	class defaultInnerClassC {
		public void publicInnerMethodC() {
			System.out.println("This is publicInnerMethodC from defaultInnerClassC");
		}

		void defaultInnerMethodC() {
			System.out.println("This is defaultInnerMethodC from defaultInnerClassC");
		}

		protected void protectedInnerMethodC() {
			System.out.println("This is protectedInnerMethodC from defaultInnerClassC");
		}

		private void privateInnerMethodC() {
			System.out.println("This is privateInnerMethodC from defaultInnerClassC");
		}
	}

	class protectedInnerClassE {
		public void publicInnerMethodE() {
			System.out.println("This is publicInnerMethodE from protectedInnerClassE");
		}

		void defaultInnerMethodE() {
			System.out.println("This is defaultInnerMethodE from protectedInnerClassE");
		}

		protected void protectedInnerMethodE() {
			System.out.println("This is protectedInnerMethodE from protectedInnerClassE");
		}

		private void privateInnerMethodE() {
			System.out.println("This is privateInnerMethodE from protectedInnerClassE");
		}
	}

	static class staticDefaultInnerClassD {
		public static void publicInnerMethodC() {
			System.out.println("This is publicInnerMethodC from staticDefaultInnerClassD");
		}

		static void defaultInnerMethodC() {
			System.out.println("This is defaultInnerMethodC from staticDefaultInnerClassD");
		}

		protected static void protectedInnerMethodC() {
			System.out.println("This is protectedInnerMethodC from staticDefaultInnerClassD");
		}

		private static void privateInnerMethodC() {
			System.out.println("This is privateInnerMethodC from staticDefaultInnerClassD");
		}
	}

}