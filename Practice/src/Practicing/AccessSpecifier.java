package Practicing;

import a_Practice.C;

public class AccessSpecifier extends C {

	public static void main(String[] args) {
		C c = new C();
		C.theta t = c.new theta();
//		C.gama g = c.new gama(); 

		c.new gama().fromGama();

		c.fromA();
	}
}
