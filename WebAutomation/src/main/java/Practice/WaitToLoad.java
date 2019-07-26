package Practice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitToLoad {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;

	static {
		System.out.println("Test Running on " + os);

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://shop.demoqa.com/");

		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		wdWait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tp-mask-wrap>#slide-6-layer-1>img")));
		System.out.println(driver.getTitle());

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
			{
			  public WebElement apply(WebDriver driver) {
			  return driver.findElement(By.id(".tp-mask-wrap>#slide-6-layer-1>img"));
			}
			});
		
		driver.close();
	}

}
