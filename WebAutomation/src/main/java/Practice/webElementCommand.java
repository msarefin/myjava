package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webElementCommand {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;
	private static String msg = "Running test on ";
	

	static {
		if (os.contains("win")) {
			System.out.println(msg + os.toUpperCase());
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";

		} else if (os.contains("mac")) {
			System.out.println(msg + os.toUpperCase());
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			System.out.println(msg + os.toUpperCase());
			chromeDriver = System.getProperty("user.dir") + "/drivers/linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		
		WebElement partialLinkText = driver.findElement(By.partialLinkText("Partial Link "));
		partialLinkText.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement linkText = driver.findElement(By.linkText("Link Test"));
		linkText.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.clear();
		firstName.sendKeys("Daniel");
		firstName.clear();
		

		driver.navigate().to("https://www.united.com/en/us");
		
		driver.quit(); 

	}
}
