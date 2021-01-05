package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ToolsQAWaits {
	public static void main(String[] args) {
//		new impwait(); 
//		new expWait();
		new flWait(); 
	}
}

class flWait {
	flWait() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS); 
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(NoSuchElementException.class); 
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("input[name='q']"));
			}
		}); 
		
		element.sendKeys("selenium Fluentwait ", Keys.ENTER);
		
		driver.close();
		driver.quit();

	}
}

class expWait {
	public expWait() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='q']")));

		element.sendKeys("selenium explicitely wait toolsqa ", Keys.RETURN);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		driver.quit();

	}
}

class impwait {
	impwait() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("selenium implecite wait", Keys.RETURN);
		String title = driver.getTitle();
		String dom = driver.getPageSource();
		String currentURL = driver.getCurrentUrl();

		System.out.println(title + " | " + currentURL);

		driver.close();
		driver.quit();
	}
}

class waiting {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("input[placeholder='Full Name']"));
			}
		});
		System.out.println(element.isDisplayed());

		WebDriverWait wdWait = new WebDriverWait(driver, 10);
		WebElement element1 = wdWait
				.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("input[placeholder='Full Name']")));

		System.out.println(element1.isDisplayed());

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(-1, TimeUnit.SECONDS);

		driver.close();
		driver.quit();

	}
}
