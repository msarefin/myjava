package learningTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Finish");

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Start " + arg0);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Test Failed But within successful Percentage" + arg0);
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Test Failure " + arg0);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("On Test Skipped" + arg0);
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("On test Starts" + arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("on test success" + arg0);
	}
}