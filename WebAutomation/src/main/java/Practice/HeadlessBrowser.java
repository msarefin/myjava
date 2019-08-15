package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HeadlessBrowser {

	private static String os;
	private static String chromeDriver;
	private static WebDriver driver;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test Runing on " + os.toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}

	}

	@BeforeMethod
	@Parameters({ "url" })
	private void setup(@Optional("http://demoqa.com/tooltip-and-double-click/") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);

		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size = 1400,800");
		option.addArguments("headless");

		driver = new ChromeDriver(option);
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	private void test() throws InterruptedException {
		System.out.println(driver.getTitle());
		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.id("tooltipDemo"));
		action.moveToElement(element).perform();
		System.out.println(element.getText());

		Thread.sleep(5000);

	}

	@AfterMethod
	private void shudtdown() {
		driver.quit();
	}

}
