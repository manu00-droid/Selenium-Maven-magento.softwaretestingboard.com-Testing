package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage5Sec {
	WebDriver ldriver;

	public SignOutPage5Sec(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/header/div[2]/a/img")
	WebElement websiteLogo;

	public void clickLogo() {
		websiteLogo.click();
	}
}
