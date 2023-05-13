package MyPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyUtilities.ReadCreateAccConfig;

public class CreateAccountPage {
	WebDriver ldriver;
	ReadCreateAccConfig readCreateAccConfig = new ReadCreateAccConfig();

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

	public void inputFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		lastNameInput.sendKeys(lastName);
	}

	public void inputEmailId(String emailId) {
		emailInput.sendKeys(emailId);
	}

	public void inputPassword(String password) {
		passInput.sendKeys(password);
	}

	public void inputConfirmPassword(String password) {
		confirmPassInput.sendKeys(password);
	}

	public void fillInfo() {
		try {
			inputFirstName(readCreateAccConfig.getFirstName());
			inputLastName(readCreateAccConfig.getLastName());
			inputEmailId(readCreateAccConfig.getEmailId());
			inputPassword(readCreateAccConfig.getPassword());
			inputConfirmPassword(readCreateAccConfig.getPassword());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickCreateAccBtn() {
		createAccBtn.click();
	}
}
