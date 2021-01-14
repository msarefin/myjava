package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement SearchBar = driver.findElement(By.cssSelector("input#search_query_top.search_query.form-control.ac_input"));
		Actions ac = new Actions(driver);
		
		ac.moveToElement(SearchBar).click().sendKeys("men").build().perform();
		
		
		driver.quit();
		
	}
}
