package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQATool_Tips {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		driver.get("https://demoqa.com/tool-tips");
		
		WebElement hoverTip = driver.findElement(By.cssSelector("button#toolTipButton"));
		
		Actions ac = new Actions(driver); 
		
		ac.moveToElement(hoverTip).build().perform(); 
		
		WebElement buttonToolTip =driver.findElement(By.cssSelector("div#buttonToolTip"));
		
		System.out.println(buttonToolTip.getText());
		
		driver.close();
		driver.quit();
	}
}
