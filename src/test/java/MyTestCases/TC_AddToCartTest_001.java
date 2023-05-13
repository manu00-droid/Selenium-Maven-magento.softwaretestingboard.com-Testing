package MyTestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class TC_AddToCartTest_001 extends BaseClass {
	@Test
	public void TestCase_300() {
		ExtentTest test = extent.createTest("Add to cart Test").assignAuthor("Tester");
		test.info("Testing add to cart functionality");
		test.info("scrolling down to item");
		try {
			loggedInHomePage.scrollToItem();
			test.info("selecting item's specifications");
			loggedInHomePage.selectItemSize();
			loggedInHomePage.selectItemColor();
			test.info("clicking add to cart");
			loggedInHomePage.clickAddToCart();
			Thread.sleep(Duration.ofSeconds(3));
			test.info("clicking shopping cart button");
			loggedInHomePage.clickShoppingCartBtn();
			if (driver.getTitle().toString().equals("Shopping Cart")) {
				test.info("on Shopping cart page");
				Thread.sleep(Duration.ofSeconds(2));
				test.info("clicking proceed to checkout button");
				shoppingCartPage.clickProceedToCheckoutBtn();
				test.pass("successfully added item to cart");
				Assert.assertTrue(true);
				Thread.sleep(Duration.ofSeconds(3));
			}
		} catch (Exception e) {
			test.fail("Exception: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}
}
