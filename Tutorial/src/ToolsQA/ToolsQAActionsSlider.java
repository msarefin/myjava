package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolsQAActionsSlider {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/slider");

		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary"));

		System.out.println(slider.getSize().getWidth());
		int sliderWidth = slider.getSize().getWidth();
		Actions ac = new Actions(driver);
		ac.moveToElement(slider).click().dragAndDropBy(slider, (sliderWidth*-125)/100, 0).build().perform();

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
