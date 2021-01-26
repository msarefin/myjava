package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JavaScriptConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsQAWebdriverManager {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().driverVersion("86.0.0").arch32().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/text-box");

		System.out.println(driver.getTitle());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement fullName = driver.findElement(By.id("userName"));
		fullName = (WebElement) js.executeScript("return document.getElementById('userName')", fullName);
		js.executeScript("document.getElementById('userName').style.color='red'");
		fullName.sendKeys("Just a Name");
		js.executeScript("return alert('This is just an alert!!!')");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.switchTo().alert().accept();
		WebElement submit = null; 
		submit = (WebElement) js.executeScript("return document.getElementById('submit')", submit);
		submit.click();
		
		System.out.println("=".repeat(100));
		System.out.println(js.executeScript("return document.getElementById('userName-label').innerText;").toString());
		System.out.println("=".repeat(100));
		
		System.out.println(js.executeScript("return document.documentElement.innerText;", submit).toString());
		
		String n = js.executeScript("return document.title").toString();
		System.out.println("=".repeat(100));
		System.out.println(n);
		
		
		
		js.executeScript("return document.getElementsByClassName('header-text')[3].scrollIntoView(true);");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
	}
}
