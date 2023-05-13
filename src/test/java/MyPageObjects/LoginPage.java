package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyUtilities.ReadLoginConfig;

public class LoginPage {
	WebDriver ldriver;
	ReadLoginConfig readLoginConfig = new ReadLoginConfig();

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

	public void setEmailId() {
		emailInput.sendKeys(readLoginConfig.getEmailId());
	}

	public void setPassword() {
		passInput.sendKeys(readLoginConfig.getPassword());
	}

	public void clickSubmit() {
		signInBtn.click();
	}
}
