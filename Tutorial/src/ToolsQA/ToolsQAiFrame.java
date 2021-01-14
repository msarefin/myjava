package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQAiFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.get("https://demoqa.com/frames");
		
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.tagName("iframe"))));
		
		driver.switchTo().frame(0); 
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getWindowHandle());
		driver.switchTo().frame(1); 
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}
}
