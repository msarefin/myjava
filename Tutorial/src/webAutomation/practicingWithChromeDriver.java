package webAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practicingWithChromeDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();

		String url = "https://www.thegreatcourses.com/";
		driver.get(url);
		driver.manage().window().maximize();

		String title = "";
		String currentURL;

		title = driver.getTitle();
		currentURL = driver.getCurrentUrl();

		System.out.println("Title : " + title);
		System.out.println("Current URL " + currentURL);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search-field']"));
		searchBar.clear();
		searchBar.sendKeys("math");
		WebElement searchButton = driver.findElement(By.xpath("//span[@class='SearchField-Icon']"));
		searchButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		title = driver.getTitle();
		currentURL = driver.getCurrentUrl();

		System.out.println(title);
		System.out.println(currentURL);

		driver.findElement(By.xpath("//*[contains(text(),'Zero to Infinity')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		title = driver.getTitle();
		currentURL = driver.getCurrentUrl();

		System.out.println(title);
		System.out.println(currentURL);

		String header = driver.findElement(By.xpath("//div[@class='ProductPage-Header-Title']/h1")).getText();
		System.out.println(header);
		driver.findElement(By.xpath("//label[contains(text(),'DVD')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		title = driver.getTitle();
		currentURL = driver.getCurrentUrl(); 
		
		System.out.println(title);
		System.out.println(currentURL);
		
		driver.findElement(By.xpath("//a[@class='ml-2 btn btn-fill-success']")).click();
		
		
		driver.close();
	}
}
