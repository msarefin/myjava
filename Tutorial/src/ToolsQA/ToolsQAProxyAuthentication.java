package ToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ToolsQAProxyAuthentication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://pntmember:pnt77319*@pntsvr1.piit.us/";
		driver.get(url);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement e : links) {
			System.out.println(e.getText());
		}
		
		driver.close();
		driver.quit();
	}
}
