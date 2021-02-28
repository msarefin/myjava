package toolsQATestNG.test;

import org.testng.annotations.Test;

import toolsQATestNG.Generic.Base.CommonAPI;
import toolsQATestNG.main.AmazonHomePage;

public class AmazoneTest extends CommonAPI{

	@Test()
	public static void test1()	{ 
		AmazonHomePage.getListOfAllDepartments();
	}
}
