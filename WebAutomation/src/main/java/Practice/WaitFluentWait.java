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

import com.google.common.base.Function;
import com.google.common.base.Functions;

public class WaitFluentWait {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;

	static {
		System.out.println("Test Running form " + os);

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");

		System.out.println(driver.getTitle());

		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#cookie-law-info-bar"))));
		driver.findElement(By.linkText("ACCEPT")).click();
		wdWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#cookie-law-info-bar"))));

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(10, TimeUnit.SECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> fn = new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {

				WebElement element = driver.findElement(By.id("colorVar"));
				System.out.println(element.isDisplayed());
				String color = element.getAttribute("color");
				System.out.println(color);
				if (color.equalsIgnoreCase("red")) {
					return true;
				}

				return false;
			}
		};

		wait.until(fn);

		driver.close();

	}

}
