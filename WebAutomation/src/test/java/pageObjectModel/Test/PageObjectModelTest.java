package pageObjectModel.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Generic.CommonAPI;
import PageObjectModel.PracticeFromPageObject;

public class PageObjectModelTest extends CommonAPI {

	@Test
	public void TestFirstAndLastNameFields() {
		System.setProperty("webdriver.chrome.logfile", "TestLog.txt");

		PracticeFromPageObject pageObject = new PracticeFromPageObject();
				PageFactory.initElements(driver, pageObject);

		pageObject.firstname.sendKeys("Max");
		pageObject.lastname.sendKeys("Payne");

		pageObject.firstname.getText();
		pageObject.lastname.getText();

	}

}
