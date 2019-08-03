package Practice;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class workingWithIframe {

	private static String os = System.getProperty("os.name").toLowerCase();
	private static String chromedriver, url;
	static WebDriver driver;

	static {
		System.out.println("Test Running on " + os.toUpperCase());

		if (os.contains("")) {
			chromedriver = System.getProperty("user.dir") + "/drivers/Windows/ChromeDriver/chromedriver.exe";
		} else if (os.contains("mac")) {
			chromedriver = System.getProperty("user.dir") + "/drivers/Mac/ChromeDriver/chromedriver";
		} else {
			chromedriver = System.getProperty("user.dir") + "/drivers/Linux/ChromeDriver/chromedriver";
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", chromedriver);
		driver = new ChromeDriver();
		url = "http://toolsqa.com/iframe-practice-page/";
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);

		System.out.println(driver.getTitle());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Integer NumberOfiFrames = Integer.parseInt(js.executeScript("return window.length").toString());
		
		System.out.println("# of iFrames : "+ NumberOfiFrames);
		
		List<WebElement> FrameList = driver.findElements(By.tagName("iframe"));
		
		System.out.println("There are "+FrameList.size()+" iframes");
		System.out.println();
		
		for(WebElement e: FrameList) {
			System.out.println(e.getAttribute("id"));
			driver.switchTo().frame(e);
			driver.switchTo().defaultContent();
			System.out.println();
		}
		
		System.out.println();
		
		driver.switchTo().frame(0); 
		System.out.println("Frame (0) title:");
		System.out.println(driver.getTitle()+"\n");
		
		
		driver.switchTo().defaultContent(); 
		
		driver.switchTo().frame(1); 
		System.out.println("Frame (1) title:");
		System.out.println(driver.getTitle()+"\n");
		

		driver.switchTo().defaultContent(); 
		
		
		driver.switchTo().frame("iframe1");
		
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame("iframe2");
		driver.switchTo().defaultContent(); 
		
		driver.switchTo().frame("IF1");
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame("IF2");
		
		
		
		
		driver.quit();
	}
}
