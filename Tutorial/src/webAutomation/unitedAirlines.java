package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class unitedAirlines {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		String url = "https://www.united.com/en/us";
		driver.get(url);
		
		WebElement flight = driver.findElement(By.cssSelector("li#bookFlightTab h3 span"));
		
		System.out.println(flight.getText());
		
		driver.close(); 
		
	}
}
