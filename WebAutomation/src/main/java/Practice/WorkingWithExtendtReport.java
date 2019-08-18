package Practice;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

public class WorkingWithExtendtReport {

	private static String os;
	private static String chromeDriver;
	private static WebDriver driver;

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

	@BeforeMethod
	@Parameters({"url"})
	private void setup(String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@Test
	private void test() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Test_Extent_report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("test");
		logger.log(Status.INFO, "Information");
		logger.log(Status.PASS, "Test Passed");
		logger.log(Status.FAIL, "Test Failed");
		extent.flush();

	}
	
	@Test
	private void test1() {
		ITestContext context = null; 
		
		File outputDirectory  = new File(context.getOutputDirectory());
		
	}

	@AfterMethod
	private void shutdown() {
		driver.quit();
	}

}
