package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class toolsqaTutorial {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://www.demoqa.com/login"; 
		String title =""; 
		String dom = ""; 
		String windowHandle = ""; 
		driver.get(url);
		driver.manage().window().maximize(); 
		
		title = driver.getTitle(); 
		dom = driver.getPageSource();
		driver.getWindowHandle();
		windowHandle = driver.getWindowHandle(); 
		System.out.println(title);
		System.out.println(windowHandle);
		
		WebElement usName = driver.findElement(By.xpath("//*[@placeholder='UserName']"));
		WebElement psWord = driver.findElement(By.xpath("//*[@placeholder='Password']"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']"));
		
		usName.sendKeys("testuser");
		psWord.sendKeys("Password@123");
		loginButton.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		title = driver.getTitle(); 
		System.out.println(title);
		WebElement invisible = driver.findElement(By.xpath("//*[@id='name']"));
		boolean b = invisible.isDisplayed();
		System.out.println(b);
		System.out.println(invisible.getText());
		
		driver.manage().deleteAllCookies();
		
		
		driver.close();
		driver.quit();
		
		
	}
}
