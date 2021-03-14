package learningTestNG;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class ListenersTestNG implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlsuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		for(ISuite suite : suites) { 
			String suiteName  = suite.getName(); 
			Map<String,ISuiteResult> suiteResults = suite.getResults(); 
			for(ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext(); 
				System.out.println("Passed Tests for suite '"+suiteName+"' is : "+tc.getPassedTests().getAllResults().size());
				System.out.println("Failed Tests for suite '"+suiteName+"' is : "+tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped Tests for suite '"+suiteName+"' is : "+tc.getSkippedTests().getAllResults().size());
			}
		}
		
		
	}

}