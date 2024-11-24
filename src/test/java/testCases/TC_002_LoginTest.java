package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test
	public void verify_account_logIn() throws IOException {
		System.out.println("verify_account_logIn");

		logger.info("*** Verify_TC_002_LoginTest Is started ***");
		HomePage hp = new HomePage(driver);
		hp.clickOnBtnMyAccount();
		hp.clickOnBtnLogin();

		LoginPage logInPage = new LoginPage(driver);
		logInPage.inputEmailAddress(p.getProperty("userName"));
		logInPage.inputPassword(p.getProperty("password"));
		logInPage.clickOnLogInButton();

		MyAccountPage myAccontPage = new MyAccountPage(driver);
		boolean targetPage = myAccontPage.isMyAccountPageExists();

		Assert.assertEquals(targetPage, true, "Login failed");

		myAccontPage.clickOnLogoutButton();

		logger.info("*** Verify_TC_002_LoginTest Is ended ***");
	}

//	// When we use Grouping, Don't forget to use all group name in Base class,
//	// @BeforeClass(groups = { "Sanity", "Regression", "Master" })
//	@Test(groups = { "Sanity", "Master" })
//	public void grp_test1_LogIn() throws InterruptedException {
//		System.out.println("1");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Sanity", "Master" })
//	public void grp_test2_LogIn() throws InterruptedException {
//		System.out.println("2");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Sanity", "Regression", "Master" })
//	public void grp_test3_LogIn() throws InterruptedException {
//		System.out.println("3");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Sanity", "Master" })
//	public void grp_test4_LogIn() throws InterruptedException {
//		System.out.println("4");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Sanity", "Master" })
//	public void grp_test5_LogIn() throws InterruptedException {
//		System.out.println("5");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Regression", "Master" })
//	public void grp_test6_LogIn() throws InterruptedException {
//		System.out.println("6");
//		Assert.assertTrue(true);
//	}
//
//	@Test(groups = { "Regression", "Master" })
//	public void grp_test7_LogIn() throws InterruptedException {
//		System.out.println("7");
//		Assert.assertTrue(true);
//	}
	

}
