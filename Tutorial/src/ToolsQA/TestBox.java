package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/text-box");

		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement permenantAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));

		fullName.clear();
		email.clear();
		currentAddress.clear();
		permenantAddress.clear();
		

		fullName.sendKeys("John Smith");
		email.sendKeys("john@smith.com");
		currentAddress.sendKeys("321 B Baker St, London, UK");
		permenantAddress.sendKeys("Overlooks Hotel, 1981 colorodo Spring, CO, USA");
		submit.click();
		
		driver.close();
	}
}
