package MyTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyPageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass {

	@Test
	public void loginTest() {
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
//		Assert.assertTrue(true);
		if (driver.getTitle().equals("My Account")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
}