package toolsQAjUnit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite.SuiteClasses;

public class Runner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuite.class);
		System.out.println("Total number of tests " + result.getRunCount());
		System.out.println("Total number of test failed " + result.getFailureCount());
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getMessage());
		}
		System.out.println(result.wasSuccessful());
	}

}
