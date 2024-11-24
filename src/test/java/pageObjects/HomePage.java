package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btnMyAccount;

	@FindBy(xpath = "//li/a[normalize-space()='Register']")
	WebElement btnRegister;
	
	@FindBy(xpath = "//li/a[normalize-space()='Login']")
	WebElement btnLogin;

	public void clickOnBtnMyAccount() {
		btnMyAccount.click();
	}

	public void clickOnBtnRegister() {
		btnRegister.click();
	}
	
	public void clickOnBtnLogin() {
		btnLogin.click();
	}

}
