package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDTTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_account_logIn_DDT(String userName, String Password, String status) {

		logger.info("*** Verify_TC_003_Login DDT Test Is started ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickOnBtnMyAccount();
			hp.clickOnBtnLogin();

			LoginPage logInPage = new LoginPage(driver);
			logInPage.inputEmailAddress(userName);
			logInPage.inputPassword(Password);
			logInPage.clickOnLogInButton();

			MyAccountPage myAccontPage = new MyAccountPage(driver);
			boolean targetPage = myAccontPage.isMyAccountPageExists();

			Thread.sleep(2000);
			if (status.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myAccontPage.clickOnLogoutButton();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (status.equalsIgnoreCase("Invalid")) {
				System.out.println("From Invalid : " + targetPage);
				if (targetPage == true) {
					myAccontPage.clickOnLogoutButton();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.info("*** Verify_TC_003_Login DDT Test Is ended ***");
	}

}
