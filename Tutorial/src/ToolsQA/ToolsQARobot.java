package ToolsQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQARobot {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/automation-practice-form");
		WebElement upload = driver.findElement(By.cssSelector("input#uploadPicture"));
		
		
		
		Robot r = new Robot(); 
		StringSelection str = new StringSelection("C:\\Users\\sunsh\\Desktop\\GoToTraining 000.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		r.mouseWheel(1);
		
		upload.sendKeys("C:\\Users\\sunsh\\Desktop\\GoToTraining 001.png");
		
		Actions ac = new Actions(driver);
		ac.moveToElement(upload).click().build().perform();; 
		
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		

		Thread.sleep(2000);

		driver.close();
		driver.quit();
	}
}
