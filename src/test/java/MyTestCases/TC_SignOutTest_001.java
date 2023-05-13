package MyTestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class TC_SignOutTest_001 extends BaseClass {

	@Test
	public void TestCase_100() {
		ExtentTest test = extent.createTest("Sign Out Test from my account page").assignAuthor("Tester");
		test.info("Testing signing out of an account");
		test.info("clicking drop down menu");
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		myAccPage.clickDropDownBtn();
		test.info("clicking sign out button");
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			myAccPage.clickSignOutBtn();
			signOutPage5Sec.clickLogo();
			String title = driver.getTitle().toString();
			test.info("captured title: " + title);
			if (title.equals("Home Page")) {
				test.pass("signed out successfully");
				Assert.assertTrue(true);
			} else {
				test.fail("couldn't signed out successfully");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			test.fail("Exception occured " + e.getMessage());
		}
	}

}
