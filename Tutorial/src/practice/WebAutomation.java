package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAutomation {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		List<WebElement> deptList = driver.findElements(By.cssSelector("select.nav-search-dropdown>option"));

		File xlsx = new File(
				"C:/Users/sunsh/Documents/JavaProject/IdeaProjects/MidTermWeekDays2020/DataTest/AmazonTest.xlsx");
		FileInputStream fis = new FileInputStream(xlsx);
		XSSFWorkbook xwb = new XSSFWorkbook(fis);
		XSSFSheet xs = xwb.getSheetAt(1);

		int r = 3;
		int n = 1;
		int row = 1;
		
		List<String> dlist = new ArrayList<String>(); 

		for (WebElement e : deptList) {
			String department = e.getText().trim(); 
			dlist.add(department); 
			System.out.println("Search for products using no keywords from \""+department+"\"");
		}
		Row rows;
		int step ; 
		for(String department: dlist) {
						
			step = 1; 
			Object[][] testSteps = {
					{"Functional\\Amazon\\ Search\\", "TC_" + String.format("%04d", n++), "Functional",	"Search for products using keywords from \"" + department + "\"","Step "+step++, "Open chrome browser", "Chrome browser launched"},
					{"","","","","Step "+step++, "Navigate to https://www.amazon.com/", "Amazon page Opened"},
					{"","","","","Step "+step++, "Click on search bar taxt area", "search bar highlighted"},
					{"","","","","Step "+step++, "click on the button on the left side of the search field and select "+"\""+department+"\"", "\""+department+"\""+ " is selected"},
					{"","","","","Step "+step++, "Enter the search keyword in to the search field", "Keyword Entered"},
					{"","","","","Step "+step++, "Click on the button on the right side of the search field","Search result is displayed"}
			};
			
			for(Object [] tr : testSteps) {
				rows = xs.createRow(row++);
				int col = 0;
				for(Object fields : tr) {
					
					rows.createCell(col++).setCellValue((String) fields);
				}
				
			}
		}
		for(String department: dlist) {
			step = 1;
			Object[][] testSteps2 = {
					{"Functional\\Amazon\\ Search\\", "TC_" + String.format("%04d", n++), "Functional",	"Search for products using no keywords from \"" + department + "\"","Step "+step++, "Open chrome browser", "Chrome browser launched"},
					{"","","","","Step "+step++, "Navigate to https://www.amazon.com/", "Amazon page Opened"},
					{"","","","","Step "+step++, "Click on search bar taxt area", "search bar highlighted"},
					{"","","","","Step "+step++, "click on the button on the left side of the search field and select "+"\""+department+"\"", "\""+department+"\""+ " is selected"},
					{"","","","","Step "+step++, "Click on the button on the right side of the search field",department+" page is displayed"}
			};
			for(Object [] tr : testSteps2) {
				rows = xs.createRow(row++);
				int col = 0;
				for(Object fields : tr) {
					
					rows.createCell(col++).setCellValue((String) fields);
				}
				
			}
		}
		
		
		FileOutputStream fos = new FileOutputStream(xlsx);
		xwb.write(fos);
		xwb.close();

		driver.close();
		driver.quit();
	}

}
