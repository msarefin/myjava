package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQAAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement alertButon = driver.findElement(By.xpath("//button[@id='alertButton']"));
		WebElement timeAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		WebElement confirmationButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		WebElement promptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));

		alertButon.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		System.out.println();

		timeAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		System.out.println();

		confirmationButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.cssSelector("span#confirmResult.text-success")).getText());
		System.out.println();

		confirmationButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.cssSelector("span#confirmResult.text-success")).getText());
		System.out.println();

		promptButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Daniel Craig");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.cssSelector("span#promptResult.text-success")).getText());
		System.out.println();

		driver.close();
		driver.quit();
	}
}
