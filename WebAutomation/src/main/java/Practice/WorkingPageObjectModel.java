package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WorkingPageObjectModel extends POM {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;

	static {
		System.out.println("Test running on " + os.toUpperCase());

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
		System.setProperty("webdriver.chrome.logfile", "TestLog.txt");

		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wdWait = new WebDriverWait(driver, 10);

		POM p = new POM();

		PageFactory.initElements(driver, p);

		wdWait.until(ExpectedConditions.visibilityOf(p.accept));
		p.accept.click();
		wdWait.until(ExpectedConditions.invisibilityOf(p.accept));

		p.firstName.sendKeys("Alex");
		p.lastName.sendKeys("James");

		driver.quit();

	}

}

class POM {

	@FindBy(how = How.LINK_TEXT, using = "ACCEPT")
	public WebElement accept;

	@FindBy(how = How.NAME, using = "firstname")
	public WebElement firstName;

	@FindBy(how = How.NAME, using = "lastname")
	public WebElement lastName;

}