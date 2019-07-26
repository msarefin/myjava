package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selection {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromeDriver;
	static {
		System.out.println("Running test from " + os);

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/windows/chromedriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/mac/chromedriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/linux/chromedriver/chromedriver";
		}
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", chromeDriver);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.toolsqa.com/automation-practice-form/");

		Select select = new Select(driver.findElement(By.id("continents")));

		System.out.println(select.isMultiple());

		select.selectByIndex(6);

		System.out.println("*****************************************************************");
		System.out.println();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		List<WebElement> continents = select.getOptions();

		for (WebElement e : continents) {
			System.out.println(e.getText());
		}

		driver.findElement(By.cssSelector("button[id='submit']")).click();
		;

		Select SeleniumCommand = new Select(driver.findElement(By.name("selenium_commands")));

		System.out.println(SeleniumCommand.isMultiple());

		List<WebElement> contrnt = SeleniumCommand.getOptions();

		for (WebElement e : contrnt) {
			System.out.println(e.getText());
		}

		driver.quit();
	}
}
