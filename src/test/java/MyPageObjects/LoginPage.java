package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public void login(String email, String pass) {
		emailInput.sendKeys(email);
		passInput.sendKeys(pass);
		signInBtn.click();
	}

}
