package ToolsQA;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeForm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		
		String url = "https://demoqa.com/automation-practice-form";
		driver.manage().window().maximize();
		driver.get(url);
		
		List<WebElement> gender = driver.findElements(By.xpath("//label[@class='custom-control-label']"));
		
		for(WebElement g: gender) {
			System.out.println(g.isSelected());
			g.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			System.out.println(g.isSelected());
			g.click();
			
		}
		
		driver.findElement(By.xpath("//input[@class=' mr-sm-2 form-control']")).sendKeys("Test");
		
		WebElement checkBoxElement = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
		boolean isSelected = checkBoxElement.isSelected();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isSelected == false) {
			 checkBoxElement.click();
			}
		System.out.println(isSelected);
		
		
		
				
		driver.close(); 
	}
}
