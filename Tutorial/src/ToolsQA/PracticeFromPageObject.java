package ToolsQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFromPageObject {

	@FindBy(how = How.CSS, using = "input[placeholder='First Name']")
	public WebElement firstname;

	@FindBy(how = How.CSS, using = "input[placeholder='Last Name']")
	public WebElement lastname;
}
