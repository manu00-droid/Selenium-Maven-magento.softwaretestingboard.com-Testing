package MyTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import MyPageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass {

	@Test
	public void loginTest() {
		Logger logger;
		logger = LogManager.getLogger(TC_LoginTest_01.class);
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setEmailId(username);
		logger.info("email id is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("sign in button is clicked");
		logger.info(driver.getTitle());
		if (driver.getTitle().equals("My Account")) {
			Assert.assertTrue(true);
			logger.info("sign in was successful");
		} else {
			Assert.assertTrue(false);
			logger.info("sign was not successful");
		}

	}
}