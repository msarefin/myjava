package toolsQATestNG.Generic.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonAPI {

	
	public static WebDriver driver = null; 
	
	@BeforeMethod
	public static void startBrowser() { 
		setupBrowser();
	}
	
	public static void setupBrowser() { 
		System.setProperty("driver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe"); 
		driver = new ChromeDriver(); 
	}
	
	public static List elementList(WebElement element) { 
		List elements = findELementBy()
	}
	
	public static WebElement findELementBy(String locatorType, String locator) {
		switch (locatorType) {
		case "id": 
			return driver.findElement(By.id(locator)); 
		case "className":
			return driver.findElement(By.className(locator)); 
		case "cssSelector":
			return driver.findElement(By.cssSelector(locator));
		case "linkText":
			return driver.findElement(By.linkText(locator));
		default:
			throw new IllegalArgumentException("Unexpected value: " + locatorType);
		}
	}
	
	@AfterMethod
	public static void teardown() { 
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
}
