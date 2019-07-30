package Practice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class WaitPredicaete {

	private static String os = System.getProperty("os.name").toLowerCase(); 
	private static String ChromeDriver;
	
	static {
		System.out.println("Test Running on "+os);
		
		if(os.contains("win")) {
			ChromeDriver = System.getProperty("user.dir")+"/drivers/Windows/Chromedriver/chromedriver.exe";
		}else if(os.contains("mac")) {
			ChromeDriver = System.getProperty("user.dir")+"/drivers/Mac/Chromedriver/chromedriver";
		}else {
			ChromeDriver = System.getProperty("user.dir")+"/drivers/Linux/Chromedriver/chromedriver";
		}
		
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ChromeDriver);
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		WebDriverWait wb = new WebDriverWait(driver, 10); 
		
		wb.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("ACCEPT"))));
		driver.findElement(By.linkText("ACCEPT")).click();
		wb.until(ExpectedConditions.invisibilityOf(driver.findElement(By.linkText("ACCEPT"))));
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		
		wait.withTimeout(10,TimeUnit.SECONDS); 
		wait.pollingEvery(2, TimeUnit.SECONDS); 
		wait.ignoring(NoSuchElementException.class); 
		
		Predicate<WebDriver> predicate = new Predicate<WebDriver>() {
			
			public boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.id("color"));
				String color = element.getAttribute("color");
				System.out.println(color);
				if(color.equals("red")){
					return true;
				}
				return false;
			}
		};
		
		
		System.out.println(predicate.toString()); 
		
		driver.quit();
		
	}
	
}
