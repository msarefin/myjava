package webAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe"); 
		
		WebDriver driver = new ChromeDriver(); 
		String url = "http://www.cnn.com"; 
		driver.get(url);
		int links = driver.findElements(By.tagName("a")).size();
		System.out.println(links);
		driver.manage().window().maximize();
		
		List<WebElement> HyperLinks = driver.findElements(By.xpath("//a[@href]"));
		
		for(WebElement l : HyperLinks) {
			if(l.isDisplayed()) {
				l.click();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				driver.navigate().to(url);
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			}else {
				
			}
			
			
			
		}
		
		driver.close();
		driver.quit();
	}
}
