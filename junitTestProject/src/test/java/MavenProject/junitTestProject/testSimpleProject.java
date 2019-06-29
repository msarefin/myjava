
package MavenProject.junitTestProject;

//import junit.framework.Assert;
import org.testng.Assert;

public class testSimpleProject {

	static int n1, n2;

	static SimpleProject sp = new SimpleProject();

	public static void main(String[] args) {

		n1 = 25;
		n2 = 5;

		int sum = sp.addition(n1, n2);
		int diff = sp.difference(n1, n2);
		int prod = sp.product(n1, n2);
		int div = sp.divide(n1, n2);

		Assert.assertEquals(30, sum);
		Assert.assertEquals(20, diff);
		Assert.assertEquals(125, prod);
		Assert.assertEquals(5, div);

	}

}
