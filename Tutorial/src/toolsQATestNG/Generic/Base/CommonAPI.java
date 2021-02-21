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
		String url = "http://www.amazon.com";
		setupBrowser();
		driver.get(url);
	}

	public static void setupBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static List elementList(String locatorType, String locator) {

		switch (locatorType) {
		case "id":
			return driver.findElements(By.id(locator));
		case "className":
			return driver.findElements(By.className(locator));
		case "cssSelector":
			return driver.findElements(By.cssSelector(locator));
		case "linkText":
			return driver.findElements(By.linkText(locator));
		case "partialLinkText":
			return driver.findElements(By.partialLinkText(locator));
		case "name":
			return driver.findElements(By.name(locator));
		case "tagName":
			return driver.findElements(By.tagName(locator));
		case "xpath":
			return driver.findElements(By.xpath(locator));
		default:
			throw new IllegalArgumentException("Unexpected value: " + locatorType);
		}
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
		case "partialLinkText":
			return driver.findElement(By.partialLinkText(locator));
		case "name":
			return driver.findElement(By.name(locator));
		case "tagName":
			return driver.findElement(By.tagName(locator));
		case "xpath":
			return driver.findElement(By.xpath(locator));
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
