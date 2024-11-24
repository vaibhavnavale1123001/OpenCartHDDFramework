package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	WebElement inputEmailAddress;

	@FindBy(id = "input-password")
	WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogIn;

	public void inputEmailAddress(String userName) {
		inputEmailAddress.sendKeys(userName);
	}

	public void inputPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void clickOnLogInButton() {
		btnLogIn.click();
	}

}
