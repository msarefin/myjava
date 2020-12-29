package webAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practicingWithChromeDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/");
	
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://www.yahoo.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		String title= driver.getTitle(); 
		System.out.println(title);
		driver.close();
	}
}
