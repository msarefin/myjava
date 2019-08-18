package Practice;

import java.io.File;

import org.testng.ITestContext;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;


public class reporting {

	private static ExtentReports extent; 
	private static ITestContext context; 
	
	
	
	public static void main(String[] args) {
		File outputDirectory = new File(context.getOutputDirectory());
		File resultDirectory = new File(outputDirectory.getParentFile(), "html");
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/ExtentReports/ExtentReports.html",true );
		Reporter.log("ExtentReportDirectory"+resultDirectory, true);
		extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment","QA").addSystemInfo("User Name","Saif Arefin");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/report-config.xml"));
		
	}
	
}
