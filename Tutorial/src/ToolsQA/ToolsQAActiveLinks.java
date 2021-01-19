package ToolsQA;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQAActiveLinks {

	public static void main(String[] args) {
		String url = "https://demoqa.com/broken";
		brokenlinks(url);
		brokenImageLink(url);
	}

	public static void brokenImageLink(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

		List<WebElement> imgList = driver.findElements(By.tagName("img"));

		for (WebElement img : imgList) {
			verifyLinks(img.getAttribute("src"));
		}

		driver.close();
		driver.quit();
	}

	public static void brokenlinks(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

		// Storing the links in a list and traversing through the links
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// This line will print the number of links and the count of links.
		System.out.println("No of links are " + links.size());

		// checking the links fetched.
		for (WebElement e : links) {
			verifyLinks(e.getAttribute("href"));
		}

		driver.quit();
	}

	public static void verifyLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			// Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
				System.out.println(httpURLConnect.getResponseCode());
			}

			// Fetching and Printing the response code obtained
			else {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
				System.out.println(httpURLConnect.getResponseCode());
			}
		} catch (Exception e) {
		}
	}
}
