package webAutomation;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class practiceWebAutomation {

	static String url = "https://www.amazon.com";
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		
		WebElement searchBar = driver.findElement(By.cssSelector("input#twotabsearchtextbox.nav-input"));
		WebElement searchButton = driver.findElement(By.cssSelector("#nav-search-submit-text > input"));
	
		searchBar.clear();
		searchBar.click();
		searchBar.sendKeys("ipad air");
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		title = driver.getTitle(); 
		System.out.println(title);
//		Thread.sleep(5000);
		driver.close();

	}
}
