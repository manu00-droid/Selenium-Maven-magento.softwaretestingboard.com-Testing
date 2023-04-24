package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage {
	WebDriver ldriver;

	public OrderPlacedPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Continue Shopping")
	WebElement continueShopping;

	public void clickContinueShopping() {
		continueShopping.click();
	}
}
