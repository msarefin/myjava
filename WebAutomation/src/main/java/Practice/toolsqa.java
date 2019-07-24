package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class toolsqa {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String url = "http://Shop.DemoQA.com";
	private static String currentURL, title, DOM, windowHangle;

	private static String chrome(String os) {
		String chromedriver;

		if (os.contains("win")) {
			chromedriver = System.getProperty("user.dir") + "/drivers/windows/ChromeDriver/chromedriver.exe";
			System.out.println("Test Running from " + os.toUpperCase());
		} else if (os.contains("mac")) {
			chromedriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
			System.out.println("Test running from " + os.toUpperCase());
		} else {
			chromedriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}

		return chromedriver;
	}

	public static void main(String[] args) {

		System.out.println(os);

		System.setProperty("webdriver.chrome.driver", chrome(os));
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		currentURL = driver.getCurrentUrl();
		title = driver.getTitle();
		DOM = driver.getPageSource();
		windowHangle = driver.getWindowHandle();
		System.out.println(currentURL + "\n" + title + "\n" + windowHangle + "\n" + DOM.length());
		System.out.println();

		url = "https://www.toolsqa.com/automation-practice-switch-windows/";
		driver.get(url);

		currentURL = driver.getCurrentUrl();
		title = driver.getTitle();
		DOM = driver.getPageSource();
		windowHangle = driver.getWindowHandle();
		System.out.println(currentURL + "\n" + title + "\n" + windowHangle + "\n" + DOM.length());
		System.out.println();

		driver.findElement(By.id("button1")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		currentURL = driver.getCurrentUrl();
		title = driver.getTitle();
		DOM = driver.getPageSource();
		windowHangle = driver.getWindowHandle();
		System.out.println(currentURL + "\n" + title + "\n" + windowHangle + "\n" + DOM.length());
		System.out.println();

		driver.navigate().to("http://www.yahoo.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().forward();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.close();
		driver.quit();
	}

}
