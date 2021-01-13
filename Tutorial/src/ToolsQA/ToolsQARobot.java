package ToolsQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQARobot {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/automation-practice-form");
		WebElement upload = driver.findElement(By.cssSelector("input#uploadPicture"));
		
		Actions ac = new Actions(driver);
		ac.moveToElement(upload).click(); 
		
		Robot r = new Robot(); 
		
		

		Thread.sleep(2000);

		driver.close();
		driver.quit();
	}
}
