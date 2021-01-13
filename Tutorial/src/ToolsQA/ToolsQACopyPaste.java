package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQACopyPaste {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/text-box");
	
		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement permenantAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']")); 
		
		Actions ac = new Actions(driver); 
		
		ac.moveToElement(fullName).click().sendKeys("Daniel Craig").build().perform();
		ac.moveToElement(email).click().sendKeys("daniel@craig.com").build().perform();
		ac.moveToElement(currentAddress).click().sendKeys("321 Alexander Street,\n GeorgeTown,\n ND ,\n 13241").build().perform();
		ac.moveToElement(currentAddress).click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		ac.moveToElement(permenantAddress).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		ac.moveToElement(submit).click().build().perform();
		
		Thread.sleep(5000);
		

		driver.close();
		driver.quit();
	}
}
