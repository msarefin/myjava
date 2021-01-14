package webAutomation;

import java.util.List;

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
		WebElement roundtrip = driver.findElement(By.cssSelector("input#roundtrip"));
		WebElement from = driver.findElement(By.cssSelector("input#bookFlightOriginInput"));
		WebElement bookingFilghtOriginInputMenu = driver.findElement(By.cssSelector("ul#bookFlightOriginInput-menu"));
		WebElement to = driver.findElement(By.cssSelector("input#bookFlightDestinationInput"));
		WebElement bookingFilghtDestinationInputMenu = driver.findElement(By.cssSelector("ul#bookFlightDestinationInput-menu"));
		WebElement departDate = driver.findElement(By.cssSelector("input#DepartDate"));
		WebElement returnDate = driver.findElement(By.id("ReturnDate"));
		WebElement travelers = driver.findElement(By.xpath("//*[@id='bookFlightModel.passengers']"));
		WebElement cabinType = driver.findElement(By.id("cabinType"));
		
				
		System.out.println(roundtrip.getText());
		
		driver.close(); 
		
	}
}
