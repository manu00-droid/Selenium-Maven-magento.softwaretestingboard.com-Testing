package extentReportBasic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MyPageObjects.CheckoutPaymentPage;
import MyPageObjects.CheckoutShippingPage;
import MyPageObjects.CreateAccountPage;
import MyPageObjects.LoggedInHomePage;
import MyPageObjects.LoggedOutHomePage;
import MyPageObjects.LoginPage;
import MyPageObjects.MyAccountPage;
import MyPageObjects.OrderPlacedPage;
import MyPageObjects.ShoppingCartPage;
import MyPageObjects.SignOutPage5Sec;

public class DemoExtentReport {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTest.html");
	WebDriver driver;
	CreateAccountPage createAccPage;
	LoggedOutHomePage loggedOutHomePage;
	LoginPage loginPage;
	LoggedInHomePage loggedInHomePage;
	MyAccountPage myAccPage;
	CheckoutPaymentPage checkoutPaymentPage;
	CheckoutShippingPage checkoutShippingPage;
	SignOutPage5Sec signOutPage5Sec;
	OrderPlacedPage orderPlacedPage;
	ShoppingCartPage shoppingCartPage;

	@BeforeTest
	public void browserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		createAccPage = new CreateAccountPage(driver);
		loggedOutHomePage = new LoggedOutHomePage(driver);
		loginPage = new LoginPage(driver);
		myAccPage = new MyAccountPage(driver);
		checkoutPaymentPage = new CheckoutPaymentPage(driver);
		checkoutShippingPage = new CheckoutShippingPage(driver);
		loggedInHomePage = new LoggedInHomePage(driver);
		signOutPage5Sec = new SignOutPage5Sec(driver);
		orderPlacedPage = new OrderPlacedPage(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

	// create account testcase
	@Test(priority = 10)
	public void TestCase_10() {
		ExtentTest test = extent.createTest("Create Account Test").assignAuthor("Tester");
		test.info("Testing creation of an account");
		loggedOutHomePage.clickCreateAccBtn();
		test.info("create account button clicked");
		String title = driver.getTitle().toString();
		test.info("captured page title: " + title);
		if (title.equals("Create New Customer Account")) {
			test.info("Reached create account page");
			test.info("Filling in the data");
//			createAccPage.createAccount("abc", "abc", "abcHello1010@gmail.com", "Nigga@1996");
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

	@Test(priority = 100) // sign out test
	public void TestCase_100() {
		ExtentTest test = extent.createTest("Sign Out Test from my account page").assignAuthor("Tester");
		test.info("Testing signing out of an account");
		test.info("clicking drop down menu");
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

	// Login in test
	@Test(priority = 200)
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
				loginPage.setEmailId("mama@gmail.com");
				loginPage.setPassword("Nigga@1996");
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

	// Add to cart TestCase
	@Test(priority = 300)
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
//			loggedInHomePage.clickCartIcon();
//			Thread.sleep(Duration.ofSeconds(5));
//			test.info("clicking cart checkout button");
//			loggedInHomePage.clickCartCheckout();
//			Thread.sleep(Duration.ofSeconds(5));
//			if (driver.getTitle().toString().equals("Checkout")) {
//				test.pass("successfully added item to cart");
//				Assert.assertTrue(true);
//			} else {
//				throw new Exception("could not get proceed to checkout");
//			}
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

	// buy testcase
	@Test(priority = 350)
	public void TestCase_350() {
		ExtentTest test = extent.createTest("Buying Test").assignAuthor("Tester");
		test.info("Testing buying functionality");
		test.info("clicking cart icon");
		try {
			Thread.sleep(Duration.ofSeconds(2));
			String title = driver.getTitle().toString();
			if (title.equals("Checkout")) {
				test.info("On checkout page");
				test.info("filling info");
				checkoutShippingPage.fillInfo();
				test.info("clicking next on shipping page");
				checkoutShippingPage.clickNext();
				if (driver.getTitle().toString().equalsIgnoreCase("Checkout")) {
					test.info("reached checkout page");
					Thread.sleep(Duration.ofSeconds(10));
					test.info("clicking place order button");
					checkoutPaymentPage.clickPlaceOrderBtn();
					Thread.sleep(Duration.ofSeconds(3));
					title = driver.getTitle().toString();
					test.info("captured page title: " + title);
					if (title.equalsIgnoreCase("Success Page")) {
						test.pass("Successfully placed order");
						Assert.assertTrue(true);
//						Thread.sleep(Duration.ofSeconds(4));
					}
				} else {
					throw new Exception("couldn't reach payment page after clicking next on shipping page");
				}
			} else {
				throw new Exception("couldn't reached checkout page after clicking checkout button");
			}
		} catch (Exception e) {
			test.fail("Exception occured: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}

	// add to wishlist testcase
	@Test(priority = 400)
	public void TestCase_400() {
		ExtentTest test = extent.createTest("Add to wish list Test").assignAuthor("Tester");
		test.info("Testing add to wishlist functionality");
		test.info("clicking continue shopping button");
		try {
			Thread.sleep(Duration.ofSeconds(4));
			orderPlacedPage.clickContinueShopping();
			String title = driver.getTitle().toString();
			if (title.equals("Home Page")) {
				test.info("On home page");
//				loggedInHomePage.scrollToItem();
				loggedInHomePage.hoverOnItem();
				test.info("clicking add to wish list button");
				loggedInHomePage.clickAddToWishListBtn();
				Thread.sleep(Duration.ofSeconds(3));
				title = driver.getTitle().toString();
				if (title.equals("My Wish List")) {
					test.pass("Item successfully added to wish list");
					Assert.assertTrue(true);
				} else {
					throw new Exception("Item couldn't added to wish list");
				}
			} else {
				throw new Exception("couldn't reach home page");
			}
		} catch (Exception e) {
			test.fail("Exception occured: " + e.getMessage());
			Assert.assertTrue(false);
		}
	}

	// view orders testcase
	@Test(priority = 500)
	public void TestCase_500() {
		ExtentTest test = extent.createTest("checking orders Test").assignAuthor("Tester");
		test.info("Testing checking of orders functionality");
		String title = driver.getTitle().toString();
		if (title.equals("My Wish List")) {
			test.info("on My Wish List page");
			test.info("clicking my orders button");
			try {
				myAccPage.clickMyOrders();
				Thread.sleep(Duration.ofSeconds(3));
				title = driver.getTitle().toString();
				if (title.equals("My Orders")) {
					test.pass("on my orders page");
					Assert.assertTrue(true);
				} else {
					throw new Exception("couldn't reach my orders page");
				}
			} catch (Exception e) {
				test.fail("Exception Occured: " + e.getMessage());
				Assert.assertTrue(false);
			}

		}

	}

//	@Test(priority = 2)
//	public void TestCase_0021() {
//		ExtentTest test = extent.createTest("Test1").assignAuthor("Manav");
//		test.info("I am verifying the page title");
//		String title = driver.getTitle().toString();
//		test.info("Captured Page Title: " + title);
//		if (title.equals("Google")) {
//			test.pass("page title verified successfully");
//		} else {
//			test.fail("page title cannot be verified succesfully");
//		}
//	}
//
//	@Test(priority = 1)
//	public void TestCase_0032() {
//		ExtentTest test = extent.createTest("Test2").assignAuthor("Manav");
//		try {
//			driver.get("https://www.youtube.com");
//			driver.findElement(By.linkText("about")).click();
//			test.pass("User is on about us page");
//		} catch (Exception e) {
//			test.fail("Was not able to click the link " + e.getMessage());
//			Assert.assertTrue(false);
//			test.addScreenCaptureFromPath(captureScreenShot(driver));
//		}
//	}
//
//	public static String captureScreenShot(WebDriver driver) {
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File destinationFilePath = new File("src/../Screenshots" + System.currentTimeMillis() + ".png");
//		String absolutePath = destinationFilePath.getAbsolutePath();
//		try {
//			FileUtils.copyFile(srcFile, destinationFilePath);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return absolutePath;
//	}

}
