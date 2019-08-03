package Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchCommand {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String ChromeDiver;

	static {
		System.out.println("Test running on " + os.toUpperCase());

		if (os.contains("win")) {
			ChromeDiver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			ChromeDiver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			ChromeDiver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ChromeDiver);
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement accept = driver.findElement(By.linkText("ACCEPT"));
		wait.until(ExpectedConditions.visibilityOf(accept));
		accept.click();
		wait.until(ExpectedConditions.invisibilityOf(accept));

		String HomeWindows = driver.getWindowHandle();

		System.out.println(HomeWindows);

		driver.findElement(By.id("button1")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().window(HomeWindows);
		
		WebElement aletElement = driver.findElement(By.cssSelector("#alert"));
		
		wait.until(ExpectedConditions.elementToBeClickable(aletElement));
		
		aletElement.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert =driver.switchTo().alert(); 
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		alert.accept();

		Set<String> handles = driver.getWindowHandles();

		for(String n: handles) {
			System.out.println(n);
			driver.switchTo().window(n);
		}

		driver.quit();
	}

}
