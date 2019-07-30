package Practice;

import java.awt.SecondaryLoop;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;

import com.google.common.base.Function;

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

//		Explicitely Wait
		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tp-mask-wrap>#slide-6-layer-1>img")));

		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#"))));
		
//		FluentWait

		Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = Fwait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.cssSelector("css"));
			}
		});

//		Page Load 
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

//		Script Timeout
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		driver.close();
	}

}
