package Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormsPractice {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;

	static {
		System.out.println("Test Running from " + os.toUpperCase());

		if (os.contains("windows")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chromeDriver);
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));

		firstName.clear();
		
		firstName.sendKeys("Ali");
		lastName.sendKeys("Ahmed");

		List<WebElement> gender = driver.findElements(By.name("sex"));

		for (WebElement e : gender) {
			System.out.println(e.isDisplayed());
			System.out.println(e.isEnabled());
			System.out.println(e.isSelected());
			e.click();
			
		}
		
		

		driver.findElement(By.cssSelector("#datepicker")).sendKeys("10222017");

		List<WebElement> yoe = driver.findElements(By.name("exp"));

		for (WebElement e : yoe) {
			e.click();
		}
		
		System.out.println();

		List<WebElement> profession = driver.findElements(By.cssSelector("input[name='profession']"));

		for(WebElement e: profession) {
			if(e.isSelected()) {
				System.out.println("Element Already selected");
			}else {
				e.click();
			}
			
			System.out.println(e.getAttribute("value"));
		}
		
		System.out.println();
		
		List<WebElement> controlGroup = driver.findElements(By.className("control-group"));

		for(WebElement e: controlGroup) {
			System.out.println(e.getTagName()+" | "+e.getCssValue("padding")+" | "+e.getAttribute("id")+" | "+e.getSize()+" | "+e.getLocation()+" | "+e.getText());
		}
		
		System.out.println();
		
		driver.findElement(By.id("submit")).submit();
		
		Thread.sleep(5000);

		driver.quit();
	}

}
