package extentRepoetsTutorial;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportPractice {
	
	public static ExtentReports extent; 
	
	public static void main(String[] args) {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/Reports/ExtentReports/extent.html", true);
		ExtentTest test = extent.startTest("This is my first test", "This is the second line in text");
		
		test.log(LogStatus.INFO, "This is what you see if it's just an info!");
		test.log(LogStatus.PASS, "This is what you see if the test passed");
		test.log(LogStatus.FAIL, "This is what you see if the test filed");
		
		String img = test.addScreenCapture("img-Path");
		test.log(LogStatus.INFO, "image", "Image attached"+img);
		
		extent.endTest(test);
		
		extent.flush();
	}
}
