package webAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class practiceWebAutomation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		String title = driver.getTitle(); 
		System.out.println(title);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("ipad pro");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}
}
