package extentReportBasic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class DemoExtentReport {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTest.html");
	WebDriver driver;

	@BeforeTest
	public void browserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

	@Test(priority = 2)
	public void TestCase_001() {
		ExtentTest test = extent.createTest("Test1").assignAuthor("Manav");
		test.info("I am verifying the page title");
		String title = driver.getTitle().toString();
		test.info("Captured Page Title: " + title);
		if (title.equals("Google")) {
			test.pass("page title verified successfully");
		} else {
			test.fail("page title cannot be verified succesfully");
		}
	}

	@Test(priority = 1)
	public void TestCase_002() {
		ExtentTest test = extent.createTest("Test2").assignAuthor("Manav");
		try {
			driver.get("https://www.youtube.com");
			driver.findElement(By.linkText("about")).click();
			test.pass("User is on about us page");
		} catch (Exception e) {
			test.fail("Was not able to click the link " + e.getMessage());
			Assert.assertTrue(false);
			test.addScreenCaptureFromPath(captureScreenShot(driver));
		}
	}

	public static String captureScreenShot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath = new File("src/../images/screenshot" + System.currentTimeMillis() + ".png");
		String absolutePath = destinationFilePath.getAbsolutePath();
		try {
			FileUtils.copyFile(srcFile, destinationFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return absolutePath;
	}

}
