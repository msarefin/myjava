package Practice;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

import bsh.StringUtil;

public class reporting {	

	private static String os;
	private static String chromeDriver;
	private static WebDriver driver;
	private static ExtentReports extent;

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

	@BeforeSuite
	public void extentSetup(ITestContext context) {
		ExtentManager.setOutputDirectory(context);
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	@Parameters({ "url" })
	public void setup(@Optional("http://www.google.com") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void startExtent(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName().toLowerCase();
		ExtentTestManager.startTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);

	}

	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();

	}

	@AfterMethod
	public void afterEachTestMethod(ITestResult result) {
		ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
		ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

		for (String group : result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}

		if (result.getStatus() == 1) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		} else if (result.getStatus() == 2) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
		} else if (result.getStatus() == 3) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
		}
		ExtentTestManager.endTest();
		extent.flush();

		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test has Failed But screnshot is not acquired");
		}
	}

	@AfterSuite
	public void generateReport() {
		extent.close();
	}

	@AfterClass
	public void EndBrowserSession() {
		driver.quit();
	}

	@Test
	public void TestAutomationTest() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);

		TestLogger.log(URL);
		TestLogger.log("This Message is just a sample message from Practice.reporting.test()");
		TestLogger.log(getClass().getSimpleName()+" : "+StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(new Object() {}.getClass().getEnclosingMethod().getName()),' '));

	}

}

class ExtentManager {

	private static ExtentReports extent;
	private static ITestContext context;

	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			File outputDirectory = new File(context.getOutputDirectory());
			File resultDirectory = new File(outputDirectory.getParentFile(), "html");
			extent = new ExtentReports(System.getProperty("user.dir") + "/Reports/Extent Reports/Copied From Mafi/ReportingExtentReports.html");
			Reporter.log("Extent Report Directory" + resultDirectory, true);
			extent.addSystemInfo("Hostname", "PNT").addSystemInfo("Environment", "QA").addSystemInfo("User Name",
					"Mohammed Arefin");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/report-config.xml"));
		}

		return extent;
	}

	public static void setOutputDirectory(ITestContext context) {
		ExtentManager.context = context;
	}
}

class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	private static ExtentReports extent = ExtentManager.getInstance();
	private static ExtentReports extentUpdate = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	}

	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public static synchronized ExtentTest startTestClass(String className, String testName) {
		return startTest(className, testName, "");
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized ExtentTest startTest(String className, String testName, String desc) {
		ExtentTest test = extentUpdate.startTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}

class TestLogger {

	public static void log(final String message) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
	}

	public static void log(final StringUtils message) {
		Reporter.log(message + "<br>", true);
		ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
	}

	public static void log(final String message, WebDriver driver) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
	}
}

class ApplicationLog {
	public static void epicLogger() {
		TestLogger.log("Browser is Launching");
	}
}

class CommonMethods{
	
}