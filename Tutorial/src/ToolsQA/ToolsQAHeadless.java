package ToolsQA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.html.Html;

public class ToolsQAHeadless {

	public static void main(String[] args) {
		htmlUnitHeadless("https://www.yahoo.com");
		htmlUnitHeadlessJavascript("http://www.google.com");
		htmlUnitDriverF("http://www.rediff.com");

	}

	static void htmlUnitHeadless(String url) {
		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
		unitDriver.get(url);

		System.out.println(unitDriver.getCurrentUrl());
		System.out.println(unitDriver.getTitle());

		unitDriver.close();
		unitDriver.quit();

	}

	static void htmlUnitHeadlessJavascript(String utl) {
		HtmlUnitDriver unitdriver = new HtmlUnitDriver(true);
		unitdriver.setJavascriptEnabled(true);
		unitdriver.get(utl);

		String n = (String)unitdriver.executeScript("return document.domain");
		System.out.println(n);

		unitdriver.close();
		unitdriver.quit();
	}
	
	static void htmlUnitDriverF(String url) {
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_78); 
		unitDriver.get(url);
		
		System.out.println(unitDriver.getCurrentUrl());
		System.out.println(unitDriver.getTitle());
		
		unitDriver.close();
		unitDriver.quit();
		
		
	}
}
