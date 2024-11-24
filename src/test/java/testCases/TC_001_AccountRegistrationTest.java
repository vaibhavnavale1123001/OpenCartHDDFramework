package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test
	public void verify_account_registration() {

		logger.info("*** Verify_account_registration TC started ***");
		HomePage hp = new HomePage(driver);
		hp.clickOnBtnMyAccount();
		hp.clickOnBtnRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());

		String gmailId = randomeString() + "@gmail.com";
		System.out.println(gmailId);
		regpage.setEmail(gmailId);// randomly generated the email

		regpage.setTelephone(randomeNumber());

		String password = randomAlphaNumeric();
		System.out.println(password);
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);

		regpage.setPrivacyPolicy();
		regpage.clickContinue();

		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		logger.info("*** Verify_account_registration TC ended ***");
	}

}
