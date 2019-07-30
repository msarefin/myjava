package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class united {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String msg = "Test is running from ";
	private static String chromeDriver;

	static {
		System.out.println(msg + os);
		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/windows/chromedriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/chromedriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/linux/chromedriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.united.com/en/us");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement CalenderShop = driver.findElement(By.cssSelector("#flexDatesLabel"));
		WebElement dates = driver
				.findElement(By.cssSelector(".app-components-FlexibleDates-flexibleDates__expandFlexMonth--3otlX"));

		if (CalenderShop.isSelected()) {
			System.out.println("Already Selected");

			if (dates.isEnabled()) {
				System.out.println("element is displayed");
			} else {
				System.out.println("Element is not displayed");
			}
		} else {
			if (dates.isEnabled()) {
				System.out.println("element is displayed");
			} else {
				System.out.println("Element is not displayed");
				CalenderShop.click();
			}

		}

		driver.quit();

	}
}
