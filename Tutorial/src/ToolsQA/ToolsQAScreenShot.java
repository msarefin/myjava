package ToolsQA;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ToolsQAScreenShot {

	public static void main(String[] args) throws IOException {

//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.toolsqa.com/selenium-webdriver/screenshot-in-selenium/");

		visibleScreenShot(driver);
		WebElement logo = driver.findElement(By.cssSelector("a[href='https://www.toolsqa.com/']"));
		ScreenShotElement(driver, logo);
		fullPageScreenShot(driver);
		screenShotElementWD4(logo);

		driver.close();
		driver.quit();
	}

	private static void visibleScreenShot(WebDriver driver) throws IOException {
		// Visible area screenshot
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/ScreenShot/VisibleScreenShot.png"));
	}

	private static void screenShotElementWD4(WebElement element) throws IOException {
		File f = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "/ScreenShot/screenshotElementWD4.png"));
	}

	private static void fullPageScreenShot(WebDriver driver) throws IOException {
		Screenshot scrshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(scrshot.getImage(), "png",
				new File(System.getProperty("user.dir") + "/ScreenShot/FullPageScreenShot.png"));

	}

	private static void ScreenShotElement(WebDriver driver, WebElement element) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullscreen = ImageIO.read(screenshot);
		Point location = element.getLocation();
		int height = element.getSize().getHeight();
		int width = element.getSize().getWidth();
		BufferedImage logoImage = fullscreen.getSubimage(location.getX(), location.getY(), width, height);
		ImageIO.write(logoImage, "png", screenshot);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/ScreenShot/logo.png"));
	}

}
