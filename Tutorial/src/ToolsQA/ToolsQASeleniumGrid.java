package ToolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ToolsQASeleniumGrid {

	public static WebDriver driver;
	 
	 public static void main(String[]  args) throws MalformedURLException, InterruptedException{
		 
//		setup hub  -->  java -jar selenium-server-standalone-3.141.59.jar -role hub port 4444
		 
//		setup node -->  java -Dwebdriver.chrome.driver=chromedriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -hub http://<hub ip>:4444/grid/register -port 5555
	 
	 String URL = "https://www.yahoo.com";
	 String Node = "http://192.168.0.13:5555/wd/hub";
	 DesiredCapabilities cap = DesiredCapabilities.chrome();
	 
	 driver = new RemoteWebDriver(new URL(Node), cap);
	 
	 
	 
	 driver.navigate().to(URL);
	 
	 System.out.println(driver.getCurrentUrl());
	 System.out.println(driver.getTitle());
	 
	 Thread.sleep(5000);
	 driver.quit();
	 } 
}
