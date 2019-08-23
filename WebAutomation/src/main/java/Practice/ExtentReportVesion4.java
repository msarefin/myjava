package Practice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.model.ITest;

public class ExtentReportVesion4 {

	private static WebDriver driver;
	private static String chromeDriver;
	private static String os;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test Running on " + os.toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}

	}

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/MyExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Mohammed Arefin");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@BeforeMethod
	@Parameters({ "url" })
	public void setup(@Optional("http://www.yahoo.com") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	@Test
	public void test() {
		String URL = driver.getCurrentUrl();
		String title = driver.getTitle();
		test = extent.createTest("test");

		System.out.println(URL);

		Assert.assertEquals("Yahoo", title);

	}

	@Test
	public void test2() {
		test = extent.createTest("test2");
		boolean status = driver.findElement(By.cssSelector("a#uh-logo")).isDisplayed();
		Assert.assertTrue(status);

	}

	@Test
	public void login() {

		test = extent.createTest("logo test");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case is : "+result.getName());
			test.log(Status.FAIL, "Test Case is : "+result.getThrowable());
			
		}

	}
}
