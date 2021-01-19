package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

public class ToolsQASSL {

	public static void main(String[] args) {

		String url = "https://expired.badssl.com/";
		chromeSSL(url);
		chromejsSSL(url);
	}

	static void chromejsSSL(String url) {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("CertificateWarningController.visitInsecureWebsiteWithTemporaryBypass()");
		
		System.out.println(driver.getTitle());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
	}

	static void chromeSSL(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(co);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(url);
		System.out.println(driver.getTitle());

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
