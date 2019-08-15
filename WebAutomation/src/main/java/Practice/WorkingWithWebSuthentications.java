package Practice;

import org.openqa.grid.selenium.node.ChromeMutator;
import org.openqa.selenium.WebDriver;

public class WorkingWithWebSuthentications {

	private static String os;
	private static String chromeDriver; 
	private static WebDriver driver; 

	static {
		os = System.getProperty("os.name").toLowerCase();

		System.out.println("Test Running on "+os.toUpperCase());
		
		if(os.contains("win")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Windows/ChromeDriver/chromedriver.exe";
		}else if(os.contains("mac")) {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Mac/ChromeDriver/chromedriver";
		}else {
			chromeDriver = System.getProperty("user.dir")+"/drivers/Linux/ChromeDriver/chromedriver";
		}
		
	}
	
	
	
}
