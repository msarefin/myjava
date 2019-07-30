package Practice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimingAlart {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String ChromeDriver;

	static {
		System.out.println("Test Running from " + os);

		if (os.contains("win")) {
			ChromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			ChromeDriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			ChromeDriver = System.getProperty("user.dir") + "/drivers/linux/ChromeDriver/chromedriver";
		}

	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ChromeDriver);

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		Wait<WebDriver> flWait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement timingALert = flWait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				return driver.findElement(By.cssSelector("button#timingAlert"));
			}
		});

		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#cookie-law-info-bar"))));

		driver.findElement(By.linkText("ACCEPT")).click();
		wdWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#cookie-law-info-bar"))));

		timingALert.click();

		Alert alert = wdWait.until(ExpectedConditions.alertIsPresent());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		alert.accept();
		
		
		
		

		driver.quit();

	}

}
