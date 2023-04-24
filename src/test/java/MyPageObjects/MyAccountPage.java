package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver ldriver;

	public MyAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "My Orders")
	WebElement myOrders;

	@FindBy(xpath = "/html/body/div[1]/header/div[2]/a/img")
	WebElement logoIcon;

	@FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")
	WebElement dropDownBtn;

	@FindBy(linkText = "Sign Out")
	WebElement signOutBtn;

	public void clickLogoIcon() {
		logoIcon.click();
	}

	public void clickMyOrders() {
		myOrders.click();
	}

	public void clickDropDownBtn() {
		dropDownBtn.click();
	}

	public void clickSignOutBtn() {
		signOutBtn.click();
	}
}
