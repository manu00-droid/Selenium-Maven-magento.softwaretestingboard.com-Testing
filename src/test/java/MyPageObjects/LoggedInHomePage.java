package MyPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInHomePage {
	WebDriver ldriver;

	public LoggedInHomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")
	WebElement dropDownBtn;

	@FindBy(linkText = "My Account")
	WebElement myAccBtn;

	@FindBy(linkText = "My Wish List")
	WebElement myWishListBtn;

	@FindBy(linkText = "Sign Out")
	WebElement signOutBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[3]/div[1]/div/div[1]")
	WebElement xsBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[3]/div[2]/div/div[2]")
	WebElement colorBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img")
	WebElement itemImage;

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button")
	WebElement addToCartBtn;

	@FindBy(xpath = "/html/body/div[1]/header/div[2]/div[1]/a")
	WebElement cartIcon;

	@FindBy(id = "top-cart-btn-checkout")
	public WebElement checkoutBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[2]/a[1]")
	WebElement addToWishListBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div[2]/div/div/div/a")
	WebElement shoppingCartBtn;

	public void selectItemSize() {
		xsBtn.click();
	}

	public void selectItemColor() {
		colorBtn.click();
	}

	public void scrollToItem() {
		((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", itemImage);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickAddToWishListBtn() {
		addToWishListBtn.click();
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public void clickCartIcon() {
		cartIcon.click();
	}

	public void clickCartCheckout() {
		checkoutBtn.click();
	}

	public void clickDropDownBtn() {
		dropDownBtn.click();
	}

	public void clickMyAccBtn() {
		try {
			myAccBtn.click();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	public void clickMyWishListBtn() {
		try {
			myWishListBtn.click();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	public void clickSignOutBtn() {
		try {
			signOutBtn.click();
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	public void clickShoppingCartBtn() {
		shoppingCartBtn.click();
	}

	public void hoverOnItem() {
		Actions action = new Actions(ldriver);
		action.moveToElement(itemImage).build().perform();
	}
}
