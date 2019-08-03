package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkingWithAlert {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver; 
	
	static {
		System.out.println("Test running on "+os.toUpperCase());
		
		if(os.contains("win")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Windows/ChromeDriver/chromedriver.exe";
		}else if(os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Mac/ChromeDriver/chromedriver";
		}else {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Linux/ChromeDriver/chromedriver";
		}
		
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		System.out.println(driver.getTitle());
		
		WebDriverWait wdWait = new WebDriverWait(driver, 10); 
		
		WebElement accept = driver.findElement(By.linkText("ACCEPT"));
		
		wdWait.until(ExpectedConditions.visibilityOf(accept)); 
		accept.click();
		wdWait.until(ExpectedConditions.invisibilityOf(accept)); 
		
		WebElement alert = driver.findElement(By.cssSelector("button#alert"));
		alert.click();
		
		Alert a = driver.switchTo().alert(); 
		
		String text = a.getText(); 
		
		System.out.println("Alert Message: "+text);
		
		a.accept();
		
		
		
		driver.quit();
	}
	
}
