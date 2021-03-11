package learningTestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LearningTestNG extends beforeAfter {
	@DataProvider(name = "data-provider")
	public Object[] dpMethod() {
		return new Object[] { "First-Value from LearningTestNG.dpMethod *************" };
	}
	@Parameters("Browser")
	@BeforeClass
	public static void beforeCurrentClass(@Optional("Chrome") String Browser) {
		System.out.println("\n@BeforeClass method runs before the current class!!!!**************");
		Reporter.log(
				"This is from the before class annotation!!!**************************************###############");
		
		System.out.println(Browser+"=".repeat(Browser.length()));
	}

	@Test(priority = 1)
	@Parameters({ "p1", "p2" })
	public static void test1(@Optional("st1 Optional Text") String st1, @Optional("St2 Optional Text") String st2) {
		System.out.println("This is test 1");
		System.out.println("String1 :" + st1 + "\n" + "=".repeat(st1.length()));
		System.out.println("String2 :" + st2 + "\n" + "+".repeat(st1.length()));
		Reporter.log("This is a log from LearningTestng CLASS test1 ???????");
	}

	@Test(groups = { "MyTest" })
	public static void test2() {
		System.out.println("This is test 2 --- - MyTest");
	}

	@Test(priority = 2)
	public static void test3() {
		System.out.println("This is test 3");

	}

	@Test(priority = -1)
	@Parameters({ "p1r", "p2" })
	public static void test4(@Optional("Optional text") String a, @Optional("second optional text ") String b) {
		System.out.println("This is test 4");
		System.out.println(a);
		System.out.println(b);
	}

	@Test(priority = 3, groups = { "MyTest" })
	public static void test5() {
		System.out.println("This is test 5 ----- - MyTest");
	}

	@Test
	public static void test6() {
		System.out.println("This is test 6");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, false);
//		Assert.assertEquals(true, false, "Failed Test case!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}

class DPTestSuite {
	@Test(dataProvider = "data-provider", dataProviderClass = LearningTestNG.class)
	public void test1(String val) {
		System.out.println("The value from DP.class dpMEthod =====>>>> " + val);
	}
}

class DP {

	@DataProvider(name = "data-provider1")
	public Object[][] dpMethod1() {
		return new Object[][] { { "First-Value from DB.dpMethod1" }, { "Second-Value from DB.dpMethod1" } };
	}

	@Test(dataProvider = "data-provider1")
	public void myTest(String val) {
		System.out.println("The value given by data provider is --->>" + val);
	}
}

class testsuite3 {

	@Test(groups = { "group 1" }, dependsOnMethods = { "test8", "test7" })
	public void test1() {
		System.out.println("This is testsuite3 test 1 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test(groups = { "group 1" })
	public void test2() {
		System.out.println("This is testsuite3 test 2 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test(groups = { "group 2" }, dependsOnGroups = { "group 3" })
	public void test3() {
		System.out.println("This is testsuite3 test 3 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test(groups = { "group 3" })
	public void test5() {
		System.out.println("This is testsuite3 test 5 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test(groups = { "group 4" })
	public void test6() {
		System.out.println("This is testsuite3 test 6 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test(groups = { "group 3" })
	public void test7() {
		System.out.println("This is testsuite3 test 7 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}

	@Test
	public void test8() {
		System.out.println("This is testsuite3 test 8 Parallel run ");
		System.out.println(Thread.currentThread().getId());
	}
}

class testsuite4 {
	@Test(groups = { "g1" })
	public void test1() {
		System.out.println("testsuite4 test1");
	}

	@Test(groups = { "g1" })
	public void test2() {
		System.out.println("testsuite4 test2");
	}

	@Test(groups = { "g2" })
	public void test3() {
		System.out.println("testsuite4 test3");
	}

	@Test(groups = { "g2" })
	public void test4() {
		System.out.println("testsuite4 test4");
	}

	@Test(groups = { "g3" })
	public void test5() {
		System.out.println("testsuite4 test5");
	}

	@Test(groups = { "g3" })
	public void test6() {
		System.out.println("testsuite4 test6");
	}

}

class testsuite2 {
	@Test(priority = 2, groups = { "MyTestFromTest2" })
	@Parameters({ "p1", "p2" })
	public void test1(@Optional("Test Suite") String test, @Optional("2") String num) {
		System.out.println(test + num + "--------------MyTestFromTest2");
	}

	@Test(priority = 1, groups = { "MyTest" })
	@Parameters({ "p1" })
	public void test2(@Optional("Test Suite ") String test) {
		System.out.println(test + "--------------MyTest");
	}

	@Test(groups = { "MyTestFromTest2" })
	public void test3() {
		System.out.println("This is testsuite2 test 3" + "-------------MyTestFromTest2");
	}
}

class web {
	@Test(groups = { "setup" })
	public void open() {
		System.out.println("\nsetup Browser opened");
	}

	@Test(groups = { "navigate" })
	public void navigate() {
		System.out.println("Navigated to the url");
	}

	@Test(priority = 1, groups = { "work on page" })
	public void getURL() {
		System.out.println("Go the URL working in page");
	}

	@Test(groups = { "setup" })
	public void maximizeWindow() {
		System.out.println("setup maximize window");
	}

	@Test(groups = { "work on page" })
	public void clickOnLink() {
		System.out.println("click on  link working on page");
	}

	@Test(groups = { "demolision" })
	public void clearBrowser() {
		System.out.println("demolision cleared browser");
	}

	@Test(groups = { "demolision" })
	public void closeBrowser() {
		System.out.println("demolision closed the browser");
	}
}

class beforeAfter {
	@BeforeSuite
	public static void beforeSuite() {
		System.out.println("\nThe @BeforeSuite method in TestNG runs before the execution of all other test methods.");
	}

	@AfterSuite
	public static void afterSuite() {
		System.out.println("This going to run after suite$$$$$$$$$$$$$$$$$$$$");
	}

	@BeforeTest
	public static void beforeTest() {
		System.out.println(
				"The @BeforeTest method in TestNG runs before the execution of all the test methods that are inside that folder.");
	}

	@AfterTest
	public static void afterTest() {
		System.out.println("running after test#########");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println(
				"The @BeforeClass method in TestNG will run before the first method invokes of the current class.");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("running after each class@@@@@@");
	}

	@BeforeMethod
	public static void beforeMethod() {
		System.out.println("The @BeforeMethod method in TestNG will execute before each test method. ");
	}

	@AfterMethod
	public static void afterMethod() {
		System.out.println("This method runs after each method!!!");
	}

}
