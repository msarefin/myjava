package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WorkingWithFileUpload {

	private static String os;
	private static String chromeDriver;
	private static WebDriver driver;

	static {
		os = System.getProperty("os.name").toLowerCase();
		System.out.println("Test running on " + os.toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/maac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	@BeforeMethod()
	@Parameters({"url"})
	private void setup(@Optional("https://cgi-lib.berkeley.edu/ex/fup.html") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);

		ChromeOptions option = new ChromeOptions(); 
		option.addArguments("window-size = 1400,800");
//		option.addArguments("headless");
		
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@Test(priority = 0)
	private void test1() throws InterruptedException {
		WebElement ele = driver.findElement(By.cssSelector("input[name = 'upfile']"));
		ele.sendKeys("C:\\Users\\sunny\\Documents\\EclipseProjects\\myjava\\WebAutomation\\Note.txt");
		
		
		System.out.println(ele.getAttribute("value"));
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(6)")).submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(5000);
		
		System.out.println(driver.findElement(By.tagName("html")).getAttribute("pre"));
		
	}
	
	@Test(priority = 1)
	private void test() throws AWTException{
		Robot robot = new Robot(); 
		
		WebElement element = driver.findElement(By.cssSelector("input[name = 'upfile']"));
		element.click();
		
		StringSelection selection = new StringSelection("C:\\Users\\sunny\\Documents\\EclipseProjects\\myjava\\WebAutomation\\Note.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		robot.delay(5000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.delay(5000);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(5000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.delay(5000);
		
		
	}
	
	
	@AfterMethod
	private void shutdown() {
		driver.quit();
	}
}
