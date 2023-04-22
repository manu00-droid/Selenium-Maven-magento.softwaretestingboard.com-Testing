package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	WebDriver ldriver;

	public CreateAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "firstname")
	WebElement firstNameInput;
	@FindBy(id = "lastname")
	WebElement lastNameInput;
	@FindBy(name = "email")
	WebElement emailInput;
	@FindBy(id = "password")
	WebElement passInput;
	@FindBy(id = "password-confirmation")
	WebElement confirmPassInput;
	@FindBy(xpath = "/html/body/div[1]/main/div[3]/div/form/div/div[1]/button")
	WebElement createAccBtn;

	public void createAccount(String firstName, String lastName, String email, String password) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		passInput.sendKeys(password);
		confirmPassInput.sendKeys(password);
		createAccBtn.click();
	}
}
