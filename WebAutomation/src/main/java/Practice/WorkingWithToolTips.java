package Practice;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.seleniumhq.jetty9.util.Uptime.Impl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	private void tooltips() {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.id("age"));
		System.out.println(ele.getAttribute("title"));

	}

	@Test(priority = 2)
	private void toolsTip() {
		driver.navigate().to("http://demoqa.com/tooltip-and-double-click/");
		Actions action = new Actions(driver); 
		WebElement ele = driver.findElement(By.id("tooltipDemo"));
		action.moveToElement(ele).perform();
		WebElement el = driver.findElement(By.cssSelector(".tooltiptext"));
		System.out.println(el.getText());
	}

	@AfterMethod
	private void teardown() {
		driver.quit();

	}
}
