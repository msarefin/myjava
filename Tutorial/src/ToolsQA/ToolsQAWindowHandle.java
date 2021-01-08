package ToolsQA;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQAWindowHandle {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/browser-windows");

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#tabButton")));

		String mainWindow = driver.getWindowHandle();

		driver.findElement(By.cssSelector("button#tabButton")).click();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//button[text()='New Tab']")).click();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//button[text()='New Window Message']")).click();

		Set<String> windows = driver.getWindowHandles();

		for (String n : windows) {
			if (n.equals(mainWindow)) {
				driver.switchTo().window(n);
				System.out.println(
						"The Parent window is : " + n + " : " + driver.getTitle() + " : " + driver.getCurrentUrl());
			} else {
				driver.switchTo().window(n);
				System.out.println(
						"The child window is : " + n);
				driver.close();
			}
		}

		driver.quit();
	}
}
