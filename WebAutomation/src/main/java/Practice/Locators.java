package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;

	static {
		System.out.println("Test Running on " + os);

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/windows/chromedriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/driver/mac/chromedriver/chromediver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/driver/linux/chromedriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/");

		List<WebElement> ancor = driver.findElements(By.tagName("a"));

		for (WebElement e : ancor) {
			System.out.println(e.getText());
		}

		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		System.out.println();
		List<WebElement> profession = driver.findElements(By.name("profession"));

		for (WebElement e : profession) {
			System.out.println(e.getAttribute("value"));
		}

		driver.close();
	}
}
