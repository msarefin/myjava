package ententReportv4;

/*
 * This is done using 
 * 
 * com.relevantcodes.extentreports
 * 
 */

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportPractice {

	ExtentReports extent; // Specify the location of the report
	ExtentTest test; // What details should be populated into the report

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/Extent Reports/TheExtentReportPractice.html", true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", "Arefin");
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

	}

	@Test
	public void demoReportPass() {
		test = extent.startTest("demoReportPass");
		test.assignCategory("demo");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert Pass as conditions true!");
	}

	@Test
	public void demoReportFail() {
		test = extent.startTest("demoReportFail");
		test.assignCategory("demo");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "Assert Fail as conditions False!");
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, result.getInstanceName());
			test.log(LogStatus.FAIL, result.getName());

			test.log(LogStatus.INFO, "Just an Info");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Skipped");
			test.log(LogStatus.INFO, result.getThrowable());
		}

		extent.endTest(test);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
}
