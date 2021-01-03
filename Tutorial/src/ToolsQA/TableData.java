package ToolsQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TableData {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		List<WebElement> tabelHead = driver.findElements(By.cssSelector("table.tsc_table_s13 thead tr th"));
			
		List<WebElement> tableRow = driver.findElements(By.cssSelector("tbody tr"));
		
		Actions ac = new Actions(driver); 
		
		for(WebElement head:tabelHead) {
			
			System.out.print(head.getText()+"\t");
		}
		
		
		
		driver.close(); 
		driver.quit();
		
	}
}
