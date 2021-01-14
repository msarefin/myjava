package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ToolsQACacheLookup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize(); 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		PracticeFromPageObject pageObject = PageFactory.initElements(driver, PracticeFromPageObject.class);
		pageObject.firstname.sendKeys("Larry");
		pageObject.lastname.sendKeys("Chester");

		Thread.sleep(5000);
		
		
		driver.quit();
		
		
	}
}

