package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		
		String locator = "//span[@class='rct-checkbox']";
		WebElement home = driver.findElement(By.xpath(locator));
		boolean b = home.isSelected(); 
		System.out.println("is the check box selected? :"+b);
		home.click();
		
		b = home.isSelected(); 
		System.out.println("is the check box selected? :"+b);
		
		driver.close();
		driver.quit();
		
		
		
	}
}
