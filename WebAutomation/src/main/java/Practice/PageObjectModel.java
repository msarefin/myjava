package Practice;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class PageObjectModel extends CommonAPI {

	@Test(priority = 1)
	public void TestCookies() {
		PracticeFromPageObject pageObject = new PracticeFromPageObject();
		PageFactory.initElements(driver, pageObject);

		WebDriverWait wdWait = new WebDriverWait(driver, 10);
		System.out.println(pageObject.cookies.isDisplayed());
		wdWait.until(ExpectedConditions.visibilityOf(pageObject.cookies));
		pageObject.cookies.click();
		System.out.println(pageObject.cookies.isDisplayed());
		wdWait.until(ExpectedConditions.invisibilityOf(pageObject.cookies));

	}

	@Test(priority = 2)
	public void TestFirstAndLastNameFields() {
		PracticeFromPageObject pageObject = new PracticeFromPageObject();
		PageFactory.initElements(driver, pageObject);

		pageObject.firstname.sendKeys("Virender"); // A FindBy call is triggered to fetch First Name
		pageObject.lastname.sendKeys("Singh"); // A FindBy call is triggered to fetch Last Name

		// Read values from the Text box.
		pageObject.firstname.getText(); // A FindBy call is triggered to fetch First Name
		pageObject.lastname.getText(); // A FindBy call is triggered to fetch Last Name

		driver.close();

	}

}

class PracticeFromPageObject {

	@FindBy(how = How.NAME, using = "firstname")
	public WebElement firstname;

	@FindBy(how = How.NAME, using = "lastname")
	public WebElement lastname;

	@FindBy(how = How.ID, using = "cookie_action_close_header")
	public WebElement cookies;

}

class CommonAPI {

	static WebDriver driver;
	static String os = System.getProperty("os.name").toLowerCase();
	static String chromeDriver;

	static {
		System.out.println("Test Runing on " + os);

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://toolsqa.com/automation-practice-form/");

	}

	@AfterClass
	public void End() {
//		driver.manage().deleteAllCookies();
		driver.quit();
	}

}