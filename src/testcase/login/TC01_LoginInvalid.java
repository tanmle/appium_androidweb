package login;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import page.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import org.testng.asserts.*;

import common.AbstractTest;

public class TC01_LoginInvalid extends AbstractTest{
	@BeforeClass(alwaysRun = true)
	public void setup(){
		driver  = openApplication();
		loginPage = PageFactory.getLoginPage(driver);
	}
	
	@Test(groups = { "regression" },description = "Login invalid: login with invalid email")
	public void loginInvalid_01_InvalidEmail()
	{
		log.info("loginInvalid_01_InvalidEmail - Step 01: Enter invalid email");
		loginPage.enterEmail("test@#@##@");
		
		log.info("loginInvalid_01_InvalidEmail - Step 02: Enter invalid email");
		loginPage.clickOnNextButton();
		
		log.info("VP: Error message 'Please enter a valid email address.'");
		Assert.assertTrue(loginPage.doesErrorMessageDisplay("Please enter a valid email address."));
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeDriver(driver);
	}
	private AndroidDriver<WebElement> driver;
	private LoginPage loginPage;
}
