package a_Practice;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import a_Practice.child;

public class OOPConcepts extends abs1 implements Ax {

	public static void main(String[] args) {
		n = "None";

		OOPConcepts oop = new OOPConcepts();

		System.out.println(oop.m);
		System.out.println(n);
		oop.myMethod();

		family f = new family();
		f.c.setter("Hello Darkness my old friend!");
		System.out.println(f.c.getter());

		System.out.println("*".repeat(10));
		f.c.asset();
		f.c.invoking();
		System.out.println("#".repeat(6));
		f.c.asset(4);
		System.out.println("******************");
		f.p.asset();

		f.pc.asset();
		f.cx.asset();
		System.out.print("8888888888888888888");
		f.px.asset();
		
	
	}

	@Override
	public void one() {
		// TODO Auto-generated method stub

	}

	@Override
	void abst() {
		// TODO Auto-generated method stub

	}

}

class program {

	public program() {
		// TODO Auto-generated constructor stub
	}

	program(int m) {
		System.out.println();
	}
}
//Abstraction
//Abstract Class 

abstract class Abs {
	String m = "just text";
	static String n = "Just a an Abstract string";

	abstract void abst();

	void myMethod() {
		System.out.println("Just my abstract");
	}

}

abstract class abs1 extends Abs {

}

//	Interface

interface Ax extends Ay {

	program p = new program();
	static final int n1 = 12;

	void one();
	
	

}

interface Ay {
	static final String msg = "This is a static final string variable";
//	int one(); 
}

//Inheritance

class family {
	child c = new child(12);
	parent p = new parent(12);
	parent pc = new child(1);

	child cx = (child) pc;

	parent px = (parent) c;

}

class child extends parent {

	public child(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	void asset() {
		System.out.println("This is from the child class - overriding");
	}

	void education() {
		System.out.println("Child chooses education!");
	}
	
	void invoking() {
		super.asset();
	}

}

class parent {

	private String nn;

	void setter(String nn) {
		this.nn = nn;
	}

	String getter() {
		return nn;
	}

	String n = "from parent";

	public parent(int x) { // constructor
		System.out.println(x);
	}

	void asset() {
		System.out.println("This is a method of assets from parent ");
	}

	void asset(int n) {
		System.out.println("This is a method of assets from Parent ".toUpperCase());
	}

}