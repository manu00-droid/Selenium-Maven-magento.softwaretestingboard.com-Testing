package MyTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
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
import MyUtilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;

	ReadConfig readConfig = new ReadConfig();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTest2.html");
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

	@BeforeClass
	public void initial() {
		System.out.println("beforeclass");
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

	@BeforeSuite
	public void config() {
		System.out.println("HELLO");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		System.out.println("YAYYY");
		extent.flush();
		driver.quit();
	}
}
