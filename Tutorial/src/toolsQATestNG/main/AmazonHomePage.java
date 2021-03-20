package toolsQATestNG.main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import toolsQATestNG.Generic.Base.CommonAPI;

public class AmazonHomePage extends CommonAPI {
	
	 public WebElement department = singleElement("cssSelector", "select.nav-search-dropdown");
	    public List<WebElement> departmentList = ListOfWebElements("cssSelector", "select.nav-search-dropdown>option");
	    public WebElement searchTextArea = singleElement("cssSelector", "input#twotabsearchtextbox.nav-input.nav-progressive-attribute");
	    public WebElement searchButton = singleElement("cssSelector", "input#nav-search-submit-button.nav-input.nav-progressive-attribute");


	public static void getListOfAllDepartments() {
		
		
		WebElement element = findELementBy("cssSelector", "select#searchDropdownBox");
		Select select = new Select(element);

		List<WebElement> departments = select.getOptions();
		
		for(WebElement dep: departments) {
			System.out.println(dep.getText()); 
		}

	}

}
