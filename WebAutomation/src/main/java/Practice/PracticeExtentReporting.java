package Practice;

/*
 * This is done using 
 * 
 * com.aventstack.extentreports
 * 
 */

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.grid.internal.RemoteProxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetTagName;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PracticeExtentReporting {

	private static WebDriver driver;
	private static String os;
	private static String chromeDriver;

	ExtentReports reports;
	ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test Running on " + os.toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	@BeforeTest
	public void setup() {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/PracticeExtentReport.html"));
		htmlReporter.loadConfig(System.getProperty("user.dir") + "/extent-config.xml");
		htmlReporter.config().setDocumentTitle("PracticeExtentReporting");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Author", "Arefin");
		reports.setSystemInfo("OS name", os.toUpperCase());
		reports.setSystemInfo("Browser", "Google Chrome");
		reports.attachReporter(htmlReporter);

	}

	@Test
	public void methodOne() {
		Assert.assertTrue(true);
		testInfo.log(Status.INFO, "This is just an info");

	}

	@Test
	public void methodTwo() {
		Assert.assertTrue(false);
		testInfo.log(Status.INFO, "This is just an info");

	}

	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
		testInfo.assignCategory("Smoke Test");
	}

	@AfterMethod
	public void captureStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "The test Method " + result.getName() + " is passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, "The test Method " + result.getName() + " is failed");
			testInfo.log(Status.FAIL, "Test failure: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.SKIP, "The test Method " + result.getName() + " is skipped");

		}
	}

	@AfterTest
	public void cleanup() {
		reports.flush();

	}

}
