package Generic;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class base {

	public static WebDriver driver;
	public static WebElement element;
	public static Properties prop;

	public static void launchBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	public static void setElement(String locatorType, String locatorValue) {

		if (locatorType.equals("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equals("javascriptExecuter")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript("return " + locatorValue + ".scrollIntoView('true')");
			element = (WebElement) js.executeScript("return " + locatorType);
		} else {
			System.err.println("Incorrect Locator Type!");
		}
		new Actions(driver).moveToElement(element);
	}

	public static WebElement getElement() {
		return element;
	}

	public static void navigateToUrl(String url) {
		driver.get(url);
	}

	public static void sendKeys(String input) {
		getElement().sendKeys(input);
	}

	public static void select(String item) {
		Select s = new Select(getElement());
		s.selectByVisibleText(item);
	}

	public static void fileUpload(String fileLocation) {
		element.sendKeys(fileLocation);

	}

	public static void click() {
		getElement().click();
	}

	public static Properties getProperty(String key) {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(key));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

	public static void userAction(String userAct, String data) {
		switch (userAct) {
		case "Launch Browser":
			launchBrowser(prop.getProperty(data));
			break;
		case "NavigateToURL":
			navigateToUrl(prop.getProperty(data));
			break;
		case "sendKeys":
			sendKeys(prop.getProperty(data));
			break;
		case "select":
			select(prop.getProperty(data));
			break;
		case "FileUpload":
			fileUpload(prop.getProperty(data));
			break;
		case "click":
			click();
			break;
		default:
			break;
		}
	}

	public static void readExcelx(String location) {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		File file = new File(location);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(1);

			for (int i = 0; i <=sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				System.out.println();
				for (int j = 3; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					System.out.print(cell.toString() + " | ");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
