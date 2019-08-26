package Practice;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
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
import com.aventstack.extentreports.utils.FileUtil;
import com.relevantcodes.extentreports.model.ITest;

import bsh.StringUtil;

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
		htmlReporter.config().setDocumentTitle("Test Automation");
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
		
		ChromeOptions option = new ChromeOptions(); 
		option.addArguments("window-size = 1400,800");
		option.addArguments("headless");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	@Test(priority = 1)
	public void noCommerceTitleTest() {
		String URL = driver.getCurrentUrl();
		String title = driver.getTitle();
		test = extent.createTest(getClass().getSimpleName() + " : "
				+ StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(new Object() {
				}.getClass().getEnclosingMethod().getName()), ' '));

		System.out.println(URL);

		Assert.assertEquals("Yahoo", title);

	}

	@Test(priority = 2)
	public void noCommerceLogoTest() {
		test = extent.createTest(getClass().getSimpleName() + " : "
				+ StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(new Object() {
				}.getClass().getEnclosingMethod().getName()), ' '));
		boolean status = driver.findElement(By.cssSelector("a#uh-logo")).isDisplayed();
		Assert.assertTrue(status);

	}

	@Test(priority = 3)
	public void noCommerceLoginTest() {

		test = extent.createTest(getClass().getSimpleName() + " : "
				+ StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(new Object() {
				}.getClass().getEnclosingMethod().getName()), ' '));
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case is : " + result.getName());
			test.log(Status.FAIL, "Test Case is : " + result.getThrowable());

			String screenshotPath = ExtentReportVesion4.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());

		} else {
			test.log(Status.PASS, "Test case PASSED is " + result.getName());
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

	public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {

		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ScreenShots/" + ScreenshotName + dataName + ".jpg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}
}
