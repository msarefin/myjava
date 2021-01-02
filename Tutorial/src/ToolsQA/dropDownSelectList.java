package ToolsQA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownSelectList {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://demoqa.com/select-menu");
		
		WebElement oldSelectDoprDown = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
		
		List<WebElement> value = new ArrayList<WebElement>(); 
		
		Select color = new Select(oldSelectDoprDown); 
		color.selectByIndex(3);
//		System.out.println(oldSelectDoprDown.getText());
		color.selectByValue("5");
//		System.out.println();
//		System.out.println(oldSelectDoprDown.getText());
		color.selectByVisibleText("Magenta");
//		System.out.println();
//		System.out.println(oldSelectDoprDown.getText());
		
		Select car = new Select(driver.findElement(By.cssSelector("select#cars")));
		value = color.getAllSelectedOptions(); 
		 
		
		
		if(car.isMultiple()) {
			car.selectByIndex(1);
			car.selectByIndex(2);
		}
		
		value = car.getAllSelectedOptions(); 
		
		System.out.println("From List values ***********");
		for(WebElement s: value) {
			System.out.println(s.getText());
		}
		
		if(car.isMultiple()) {
			car.selectByIndex(1);
			car.selectByIndex(2);
		}


		Select select = new Select(driver.findElement(By.cssSelector("select#cars")));
        System.out.println("*****************************");
		// Get all the selected option of the dropdown
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for(WebElement j : selectedOptions) {
			
			System.out.println(j.getText());
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		driver.close();
		driver.quit();
	}
}
