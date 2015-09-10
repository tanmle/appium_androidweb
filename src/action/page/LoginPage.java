package page;

import io.appium.java_client.android.AndroidDriver;
import mobilewebproject.Interfaces;

import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

	public LoginPage(AndroidDriver<WebElement> driver) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
	}
	/**
	 * Click Register button
	 */
	public void enterEmail(String email)
	{
		waitForControl(driver, Interfaces.LoginPage.TXT_EMAIL, timeWait);
		type(driver, Interfaces.LoginPage.TXT_EMAIL,email);
		sleep();
	}
	/**
	 * Click on Next button
	 */
	public void clickOnNextButton()
	{
		waitForControl(driver, Interfaces.LoginPage.BTN_NEXT, timeWait);
		click(driver, Interfaces.LoginPage.BTN_NEXT);
		sleep();
	}
	/**
	 * Verify error message displays with content
	 * @param content
	 * @return
	 */
	public boolean doesErrorMessageDisplay(String content)
	{
		waitForControl(driver, Interfaces.LoginPage.LBL_DYNAMIC_ERROR,content,timeWait);
		return isControlDisplayed(driver, Interfaces.LoginPage.LBL_DYNAMIC_ERROR,content);
	}
	private AndroidDriver<WebElement> driver;
}
