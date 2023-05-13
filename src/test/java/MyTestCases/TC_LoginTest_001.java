package MyTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void TestCase_200() {
		ExtentTest test = extent.createTest("Login Test").assignAuthor("Tester");
		test.info("Testing signing in");
		test.info("clicking sign in button");
		try {
			loggedOutHomePage.clickSignInBtn();
			String title = driver.getTitle().toString();
			if (title.equals("Customer Login")) {
				test.info("On Login Page");
				test.info("filling the data");
//				loginPage.setEmailId("mama@gmail.com");
//				loginPage.setPassword("Nigga@1996");
				test.info("clicking submit button");
				loginPage.clickSubmit();
				title = driver.getTitle().toString();
				test.info("captured page title: " + title);
				if (title.equals("Home Page")) {
					test.pass("Logged in successfully");
					Assert.assertTrue(true);
				}
			} else {
				test.fail("couldn't reach login page");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			test.fail("couldn't logged in exception occured: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}

}
