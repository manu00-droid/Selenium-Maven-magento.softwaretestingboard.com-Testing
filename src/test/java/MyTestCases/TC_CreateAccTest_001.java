package MyTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class TC_CreateAccTest_001 extends BaseClass {

	@Test
	public void TestCase_10() {
		ExtentTest test = extent.createTest("Create Account Test").assignAuthor("Tester");
		test.info("Testing creation of an account");
//		try {
//			Thread.sleep(Duration.ofSeconds(3));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		loggedOutHomePage.clickCreateAccBtn();
		test.info("create account button clicked");
		String title = driver.getTitle().toString();
		test.info("captured page title: " + title);
		if (title.equals("Create New Customer Account")) {
			test.info("Reached create account page");
			test.info("Filling in the data");
			// fetch the data from config file!!
			createAccPage.fillInfo();
			test.info("clicking create account button");
			createAccPage.clickCreateAccBtn();
			title = driver.getTitle().toString();
			if (title.equals("My Account")) {
				test.pass("Account created Successfully");
				Assert.assertTrue(true);
			} else {
				test.fail("Account didn't created succesfully");
				Assert.assertTrue(false);
			}
		} else {
			test.fail("cannot reach create account page");
		}

	}
}
