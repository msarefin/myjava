package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAWebdriverManager {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().driverVersion("86.0.0").arch32().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		System.out.println(driver.getTitle());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName = (WebElement) js.executeScript("return document.getElementById('userName') '", fullName);

		fullName.sendKeys("Just a Name");
		js.executeScript("return alert('This is just an alert!!!')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().alert().accept();

		driver.close();
		driver.quit();
	}
}
