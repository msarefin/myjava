package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WorkingWithToolTips {

	private static String os;
	private static String chromeDriver;
	private static WebDriver driver;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test Running on " + os.toLowerCase().toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}

	}

	@Parameters({ "url" })
	@BeforeMethod
	private void setup(@Optional("http://demoqa.com/tooltip/") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	@AfterMethod
	private void teardown() {
		driver.quit();
		
	}
}
