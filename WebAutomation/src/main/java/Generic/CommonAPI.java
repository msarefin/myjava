package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameter;

public class CommonAPI {

	protected static WebDriver driver;
	protected static String os;
	protected static String chromeDriver;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test is running on " + os.toUpperCase());

		if(os.contains("win")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Windows/ChromeDriver/chromedriver.exe";
		}else if(os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Mac/ChromeDriver/chromedriver";
		}else {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		
		driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-form/");
		
	}
	
	@AfterMethod
	public void cleanup() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
}
