package MavenProject.junitTestProject;

public class SimpleProject {

	int addition(int n1, int n2) {
		return n1 + n2;
	}

	int difference(int n1, int n2) {
		return n1 - n2;
	}

	int product(int n1, int n2) {
		return n1 * n2;
	}

	int divide(int n1, int n2) throws ArithmeticException {

		if(n1>n2) {
			return n1/n2;
		}else {
			return n2/n1;
		}
	}

}
