package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFromPageObject {

	@FindBy(how= How.NAME, using = "firstname")
	public WebElement firstname; 
	
	@FindBy(how = How.NAME, using = "lastname")
	public WebElement lastname; 
	
}
