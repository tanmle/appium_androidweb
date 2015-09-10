package page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class PageFactory {
	
	/**
	 * Get login page
	 * @param driver
	 * @return Login page
	 */
	public static LoginPage getLoginPage(AndroidDriver<WebElement> driver)
	{
		return new LoginPage(driver);
	}	
	/**
	 * Get register page
	 * @param driver
	 * @return Register page
	 */
	
}
