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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearningTestNG extends beforeAfter {

	@BeforeClass
	public static void beforeCurrentClass() {
		System.out.println("\n@BeforeClass method runs before the current class!!!!**************");
		Reporter.log("This is from the before class annotation!!!**************************************###############");
	}

	@Test(priority = 1)
	public static void test1() {
		System.out.println("This is test 1");
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
		Assert.assertEquals(true, false);
	}

}

class testsuite3 extends beforeAfter{

	@Test(groups = { "group 1" }, dependsOnMethods = { "test8", "test7" })
	public void test1() {
		System.out.println("This is testsuite3 test 1");
	}

	@Test(groups = { "group 1" })
	public void test2() {
		System.out.println("This is testsuite3 test 2");
	}

	@Test(groups = { "group 2" }, dependsOnGroups = { "group 3" })
	public void test3() {
		System.out.println("This is testsuite3 test 3");
	}

	@Test(groups = { "group 3" })
	public void test5() {
		System.out.println("This is testsuite3 test 5");
	}

	@Test(groups = { "group 4" })
	public void test6() {
		System.out.println("This is testsuite3 test 6");
	}

	@Test(groups = { "group 3" })
	public void test7() {
		System.out.println("This is testsuite3 test 7");
	}

	@Test
	public void test8() {
		System.out.println("This is testsuite3 test 8");
	}
}

class testsuite4 extends beforeAfter{
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

class testsuite2 extends beforeAfter{
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

class web extends beforeAfter{
	@Test(groups = { "setup" })
	public void open() {
		System.out.println("setup Browser opened");
	}

	@Test(groups = { "navigate" })
	public void navigate() {
		System.out.println("Navigated to the url");
	}
	
	@Test( priority = 1, groups = {"work on page"})
	public void getURL() {
		System.out.println("Go the URL working in page");
	}
	
	@Test(groups = {"setup"})
	public void maximizeWindow() {
		System.out.println("setup maximize window");
	}
	
	@Test(groups = {"work on page"})
	public void clickOnLink() {
		System.out.println("click on  link working on page");
	}
	
	@Test(groups = {"demolision"})
	public void clearBrowser() {
		System.out.println("demolision cleared browser");
	}
	
	@Test(groups = {"demolision"})
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
		Reporter.log("This is a log that runs after each method call******");
	}

}
