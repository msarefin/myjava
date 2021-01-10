package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQAActions {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/automation-practice-form");

		WebElement firstname = driver.findElement(By.id("firstName"));
		WebElement lastname = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement mobileNumber = driver.findElement(By.id("userNumber"));
		WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
		WebElement subject = driver.findElement(By.id("subjectsContainer"));
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));

		Actions ac = new Actions(driver);
		
		ac.contextClick(firstname).perform();
		firstname.sendKeys("Danney");
		
		Thread.sleep(5000);

		driver.close();
	}
}
