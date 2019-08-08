package Practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.DaemonExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.JCommander.Builder;

public class WorkingWithAction {

	static String os = System.getProperty("os.name").toLowerCase();
	static String chromeDriver = null;
	static WebDriver driver = null;

	static {
		System.out.println("Test Runing on " + os.toUpperCase());

		if (os.contains("win")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromeDriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}

		System.out.println(chromeDriver);
	}

	@Parameters({ "url" })
	@BeforeMethod
	private void setup(@Optional("https://demoqa.com/tooltip-and-double-click/") String url) {
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	private void testRightClick() throws InterruptedException {

		System.out.println(driver.getTitle());
		Actions action = new Actions(driver);
		WebElement rtClick = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rtClick).perform();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement second = driver.findElement(By.xpath(".//div[@id='rightclickItem']/div[1]"));
		wait.until(ExpectedConditions.visibilityOf(second));
		second.click();
		Alert alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Right Click Alert Message:::" + alert.getText());
		alert.accept();
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	private void testDoubleClick() {
		Actions action = new Actions(driver);
		WebElement dbClick = driver.findElement(By.cssSelector("button#doubleClickBtn"));
		WebDriverWait wait = new WebDriverWait(driver, 10);

		action.doubleClick(dbClick).perform();

		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Double click Alert Message:::" + alert.getText());
		alert.accept();

	}

	@Test(priority = 3)
	private void dragDrop() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href ='https://demoqa.com/droppable/']")).click();
		System.out.println(driver.getTitle());
		assertEquals(driver.getCurrentUrl(), "https://demoqa.com/droppable/");

		Actions dragDrop = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		System.out.println(target.getText());
		dragDrop.dragAndDrop(source, target).perform();
		System.out.println(target.getText());

		Thread.sleep(3000);

	}

	@Test(priority = 4)
	private void dragNDrop() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions dragDrop = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		int xOffsetS = source.getLocation().getX();
		int yOffsetS = source.getLocation().getY();

		int xOffsetT = target.getLocation().getX();
		int yOffsetT = target.getLocation().getY();

		int xOffset = (xOffsetT - xOffsetS) + 10;
		int yOffset = (yOffsetT - yOffsetT) + 20;

		dragDrop.dragAndDropBy(source, xOffset, yOffset).perform();

		Thread.sleep(4000);

	}

	@Test(priority = 5)
	private void mouseHover() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/menu/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		WebDriverWait wait = new WebDriverWait(driver, 10);

		Actions action = new Actions(driver);
		WebElement Music = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
		action.moveToElement(Music).perform();

		WebElement Rock = driver.findElement(By.xpath(".//div[contains(text(),'Rock')]"));
		wait.until(ExpectedConditions.visibilityOf(Rock));
		action.moveToElement(Rock).perform();

		WebElement Alternative = driver.findElement(By.xpath(".//div[contains(text(),'Alternative')]"));
		wait.until(ExpectedConditions.visibilityOf(Alternative));
		action.moveToElement(Alternative).perform();

		Alternative.click();
	}

	@Test(priority = 6)
	private void MouseHoverSlideBar() throws InterruptedException {
		driver.navigate().to("http://demoqa.com/slider/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		WebElement slider = driver.findElement(By.id("slider"));

		action.moveToElement(slider, 175, 0).release().build().perform();
		slider.click();
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		action.clickAndHold(slider).moveByOffset(733,0).release().build().perform();

		Thread.sleep(5000);
	}

	@AfterMethod
	private void close() {
		driver.close();
	}

}
