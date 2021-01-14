package ToolsQA;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class AdvancedWebDriverWait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(2, TimeUnit.SECONDS); 
		wait.ignoring(NoSuchElementException.class); 
		
		driver.findElement(By.cssSelector("button#timerAlertButton")).click();
		
		
		wait.until(ExpectedConditions.alertIsPresent()); 
		
		driver.close();
		driver.quit(); 
	}
}
