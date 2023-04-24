package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedOutHomePage {
	WebDriver ldriver;

	public LoggedOutHomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Sign In")
	WebElement signInBtn;

	@FindBy(linkText = "Create an Account")
	WebElement createAccBtn;

	public void clickSignInBtn() {
		signInBtn.click();
	}

	public void clickCreateAccBtn() {
		createAccBtn.click();
	}

}
