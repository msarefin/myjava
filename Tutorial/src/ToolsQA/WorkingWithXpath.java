package ToolsQA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithXpath {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.yahoo.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		List<WebElement> headerNav = driver.findElements(By.xpath("//ul/li[@class='_yb_1o28d']"));
		
		for(WebElement nav: headerNav) {
			System.out.print("|"+nav.getText()+"|");
		}
		
		WebElement YSearch = driver.findElement(By.xpath("//input[@id='ybar-sbq']"));
		
		YSearch.sendKeys("Apple Iphone", Keys.ENTER);
		
		
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();

	}
}
