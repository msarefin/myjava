package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class base {

	public static WebDriver driver;
	public static WebElement element;
	public static Properties prop;

	static String description;

	static String userAction;
	static String locatorType;
	static String locatorValue;
	static String data;

	public static void setElement(String locatorType, String locatorValue) {
		String locator = prop.getProperty(locatorValue);
		// F G
		if (locatorType.equals("id")) {
			element = driver.findElement(By.id(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.className(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.cssSelector(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.linkText(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.name(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.partialLinkText(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.tagName(locator));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.xpath(locator));
		} else if (locatorType.equals("javascriptExecuter")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeAsyncScript("return " + locator + ".scrollIntoView('true')");
			element = (WebElement) js.executeScript("return " + locator);
		} else {

		}

	}

	public static void launchBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public static WebElement getElement() {
		new Actions(driver).moveToElement(element);
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
		getElement().sendKeys(fileLocation);

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

	public static String[] excelRow(String xlsx, int rowi) {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;

		String[] cell = new String[5];
		File file = new File(xlsx);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(1);

			row = sheet.getRow(rowi);
			System.out.println();

			for (int i = 0; i < row.getLastCellNum() - 3; i++) {
				cell[i] = row.getCell(i + 3).toString();
			}

//			System.out.println(Arrays.toString(cell));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cell;

	}

	public static void readExcelx(String xlsx) {
		String[] rowData = excelRow(xlsx, 0);
		System.out.println(Arrays.toString(rowData));
	}
}
