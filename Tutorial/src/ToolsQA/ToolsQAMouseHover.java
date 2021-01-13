package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQAMouseHover {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe"); 
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		WebElement fullName = driver.findElement(By.cssSelector("input#userName"));
		WebElement userEmail = driver.findElement(By.cssSelector("input#userEmail"));
		WebElement currentAddress = driver.findElement(By.cssSelector("textarea#currentAddress"));
		WebElement permenantAddress = driver.findElement(By.cssSelector("textarea#permanentAddress"));
		WebElement submitButton = driver.findElement(By.cssSelector("button#submit")); 
		
		Actions ac = new Actions(driver); 
		
		ac.moveToElement(fullName).click().keyDown(Keys.SHIFT).sendKeys("alexander Hamilton").keyUp(Keys.SHIFT).build().perform();
		ac.moveToElement(userEmail).click().sendKeys("alexander@hamilton.com").build().perform();
		ac.moveToElement(currentAddress).click().sendKeys("321 Baker St, \n London, \n UK").build().perform();
		ac.moveToElement(permenantAddress).click().sendKeys("1001 North QueensLand, Bratislava, Germany").build().perform();
		Thread.sleep(2000);
		ac.moveToElement(submitButton).click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		
		
		driver.close();
		driver.quit();
	}
}
