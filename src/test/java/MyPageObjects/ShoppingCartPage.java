package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver ldriver;

	public ShoppingCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button")
	WebElement proceedToCheckoutBtn;

	public void clickProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}
}
