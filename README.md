# Selenium-Maven-magento.softwaretestingboard.com-Testing
ThisThis repository contains an automated testing project for the Magento website hosted on https://magento.softwaretestingboard.com/. The project uses the Selenium WebDriver framework, the Maven build automation tool, and the ExtentReports library to perform automated tests on the website.

## Getting Started
To get started with this project, you will need to clone this repository to your local machine:
```
git clone https://github.com/your-username/selenium-maven-magento-testing.git
```
Once you have cloned the repository, you can navigate to the project directory and run the tests using Maven:

```
cd selenium-maven-magento-testing
mvn test
```

The tests will run in your default browser and generate a report with the test results in HTML format. You can find the report in the test-output directory.

## Project Structure
The project is organized into several directories:

__src/test/java:__ contains all the directories having classes that implement the automated tests using the Page Object Model  
__src/test/java/MyPageObjects:__ contains all the page element objects used while automating test cases  
__src/test/java/extentReportBasic:__ contains the DemoExtentReport.java class that implements all the testcases and generates report generated by ExtentReports  
The __pom.xml__ file at the root of the project defines the project dependencies and build configuration for Maven, including the ExtentReports dependency.  

## Using ExtentReports
This project uses the ExtentReports library to generate HTML reports of the test results. The reports include detailed information about the test cases, including screenshots and error messages.
![image](https://user-images.githubusercontent.com/79694635/234108426-b3d871be-a10a-41da-adaf-186a1bf19020.png)  

## Using the Page Object Model
This project uses the Page Object Model (POM) to organize the code and make it easier to maintain. Each web page in the Magento website is represented by a separate Java class, which contains the web elements and methods for interacting with the page.

For example, here is a sample __LoginPage__ class that represents the login page in the Magento website:

```
public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "pass")
	WebElement passInput;

	@FindBy(id = "send2")
	WebElement signInBtn;

	public void setEmailId(String email) {
		emailInput.sendKeys(email);
	}

	public void setPassword(String pass) {
		passInput.sendKeys(pass);
	}

	public void clickSubmit() {
		signInBtn.click();
	}
}
```


## Test Cases
This project includes the following test cases:

1. Create account
2. Sign out
3. Sign in
4. Add to cart
5. Place order
6. Check orders
7. Add to wishlist

Each test case is implemented in DemoExtentReport.java class in the src/test/java/extentReportBasic directory, using the Page Object Model to interact with the web pages.

## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
