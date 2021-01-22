package ToolsQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQALog4j {

	public static void main(String[] args) throws IOException {
		workingWithLog4j("http://www.ebay.com");
	}

	final private static Logger log = LogManager.getLogger(ToolsQALog4j.class);

	static void workingWithLog4j(String url) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(url);

		WebElement shopByCategory = driver.findElement(By.cssSelector("button#gh-shop-a"));
		shopByCategory.click();
		WebElement Electronics = driver.findElement(By.linkText("Electronics"));
		Electronics.click();
		WebElement ComputerAccessories = driver.findElement(By.linkText("Computers, Components & Accessories"));
		ComputerAccessories.click();

		Actions ac = new Actions(driver);
		WebElement ipad = driver.findElement(By.linkText("iPads"));
		ac.moveToElement(ipad).click().build().perform();
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("generic warning");
		}
//		WebElement storageCapacity = driver.findElement(By.linkText("Storage Capacity"));
//		ac.moveToElement(storageCapacity).click().build().perform();
		WebElement capacity = driver.findElement(By.linkText("256 GB"));
		ac.moveToElement(capacity).click().build().perform();

		WebElement size = driver.findElement(By.linkText("11 in - 12.9 in"));
		ac.moveToElement(size).click().build().perform();
		WebElement wifi = driver.findElement(By.linkText("11 in - 12.9 in"));
		wifi.click();

		List<WebElement> productList = driver.findElements(By.xpath("//h3[@class='s-item__title']//ancestor::a"));
		int index = 1;
		for (WebElement item : productList) {
			try {

				URL url1 = new URL(item.getAttribute("href"));
				HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() <= 400) {
					System.out.println("Link status : " + httpURLConnection.getResponseMessage());
					System.out.println(httpURLConnection.getResponseCode());
					System.out.println(item.findElement(By.cssSelector("h3.s-item__title")).getText());

				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.close();
		driver.quit();
	}

}
