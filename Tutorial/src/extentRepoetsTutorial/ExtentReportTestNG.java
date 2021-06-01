package extentRepoetsTutorial;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTestNG extends BaseExample {
	@Test
	public void passTest() {
		test = extent.startTest("pass Test");
		test.log(LogStatus.PASS, "Pass");
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	}

	@Test
	public void interntionalFailure() throws Exception {
		test = extent.startTest("Intentional Failure");
		test.log(LogStatus.FAIL, "Filed Test Intentionally!");
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
		throw new Exception("Intentional Failure successfull!!!");
	}
}

class ExtentManager {
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter(String filePath) {
		if (extent == null) {
			extent = new ExtentReports(filePath, true);
			extent.addSystemInfo("Host Name: ", "MSA").addSystemInfo("Environment", "QA");
		}
		return extent;

	}
}

abstract class BaseExample {
	ExtentReports extent;
	ExtentTest test;

	final String filePath = "/Reports/ExtentReports/ExtentTestNG.html";

	@AfterMethod
	void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test was Skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test Passed!!");

		}
		extent.endTest(test);
		extent.flush();
	}

	@BeforeSuite
	void beforeSuite() {
		extent = ExtentManager.getReporter(System.getProperty("user.dir")+filePath);
		
	}

	@AfterSuite
	void afterSuite() {
		extent.close();
	}

}