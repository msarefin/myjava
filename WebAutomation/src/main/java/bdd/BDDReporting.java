package bdd;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.model.ITest;

public class BDDReporting {

	private static ExtentReports reports;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	ExtentTest node;

	@BeforeTest
	public void setup() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/BDD/BDDReport.html");
		htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");
		htmlReporter.config().setDocumentTitle("BDD Test");
		htmlReporter.config().setReportName("BDD Functional Report");
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Author", "Arefin");
		reports.setSystemInfo("Browser", "Google Chrome");
	}

	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		test = reports.createTest(testName);
		node = test.createNode(method.getName());

	}

	@Test
	public void test1() {
		Assert.assertTrue(true);
		node.log(Status.INFO, "This is Test 1");

	}

	@Test
	public void test2() {
		Assert.assertTrue(true);
		node.log(Status.INFO, "This is Test 2");
	}

	@AfterMethod
	public void captureStatus(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			node.pass("Node passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			node.fail("Node Failed");
		} else {
			node.skip("Node Failed");
		}

	}

	@AfterTest
	public void teardown() {
		reports.flush();

	}

}
