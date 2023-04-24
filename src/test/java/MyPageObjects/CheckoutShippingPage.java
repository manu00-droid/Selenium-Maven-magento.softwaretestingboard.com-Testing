package MyPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutShippingPage {
	WebDriver ldriver;

	public CheckoutShippingPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[1]/div/input")
	WebElement firstName;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[2]/div/input")
	WebElement lastName;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input")
	WebElement address;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input")
	WebElement city;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select")
	WebElement stateDropDownMenu;

	@FindBy(name = "postcode")
	WebElement postcode;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select")
	WebElement countryDropDownMenu;

	@FindBy(name = "telephone")
	WebElement phoneNumber;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")
	WebElement shippingMethodRadioBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")
	WebElement nextBtn;

	@FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/div[1]/div/div/div/button")
	WebElement savedAddress;

	public void inputFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public void inputAddress(String address) {
		this.address.sendKeys(address);
	}

	public void inputCity(String city) {
		this.city.sendKeys(city);
	}

	public void inputStateFromDropDownMenu(String state) {
		Select dropState = new Select(stateDropDownMenu);
		dropState.selectByVisibleText(state);
	}

	public void inputCountryFromDropDownMenu(String country) {
		Select dropCountry = new Select(countryDropDownMenu);
		dropCountry.selectByVisibleText(country);
	}

	public void inputPostalCode(String postalCode) {
		postcode.sendKeys(postalCode);
	}

	public void inputPhoneNumber(String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);
	}

	public void selectShippingMethodRadioBtn() throws Exception {
		shippingMethodRadioBtn.click();
		if (!shippingMethodRadioBtn.isSelected()) {
			throw new Exception("Not able to select shipping method radio button");
		}
	}

	public void clickNext() {
		nextBtn.click();
	}

	public void fillInfo() throws Exception {
		if (!ldriver
				.findElements(
						By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/div[1]/div/div/div"))
				.isEmpty()) {
			System.out.println("ALREADY FILLED");
			return;
		} else {
			inputFirstName("Manav");
			inputLastName("Sidana");
			inputAddress("Lahori Gate");
			inputCity("Patiala");
			inputCountryFromDropDownMenu("India");
			inputStateFromDropDownMenu("Punjab");
			inputPostalCode("147001");
			inputPhoneNumber("9988566892");
			selectShippingMethodRadioBtn();

		}
	}

}
