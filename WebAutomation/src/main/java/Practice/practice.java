package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {

	private static String chromedriver;
	private static String os = System.getProperty("os.name").toLowerCase();
	private static String msg = "Running test from ";

	private static String url = "http://demoqa.com";

	private static String currentURL, title, DOM, windowHangle;

	static {
		if (os.contains("win")) {
			System.out.println(msg + os.toUpperCase());
			chromedriver = System.getProperty("user.dir") + "/drivers/windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			System.out.println();
			chromedriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			System.out.println();
			chromedriver = System.getProperty("user.dir") + "/driver/Linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromedriver);
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		currentURL = driver.getCurrentUrl();
		title = driver.getTitle();
		DOM = driver.getPageSource();
		windowHangle = driver.getWindowHandle();
		System.out.println(currentURL + "\n" + title + "\n" + windowHangle + "\n" + DOM.length());
		System.out.println();

		driver.close();
		driver.quit();

	}
}
