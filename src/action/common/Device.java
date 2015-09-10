package common;

import java.io.File;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.ProviderConfiguration;

public class Device {

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}
	
	/*
	 * Lauch application
	 */
	public AndroidDriver<WebElement> launch()  {

		try {
			
		provider.loadInstance("MobileWebProject");
		
		final String browser = ProviderConfiguration.getProvider().getInstance().getBrowser();
		final String url = ProviderConfiguration.getProvider().getInstance().getURL();
		final String deviceName = ProviderConfiguration.getProvider().getInstance().getDeviceName();
		final String devicePlatform = ProviderConfiguration.getProvider().getInstance().getDevicePlatform();
		final String appiumURL = ProviderConfiguration.getProvider().getInstance().getAppiumURL();
		
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName",deviceName);
	    capabilities.setCapability("platformVersion", devicePlatform);
	    capabilities.setCapability("app", browser);
	    driver = new AndroidDriver<>(new URL(appiumURL), capabilities);
	    driver.get(url);
	    
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return driver;
	}
	/**
	 * Close driver
	 */
	public void shutdown() {
		driver.quit();
	}

	
	private AndroidDriver<WebElement> driver = null;
	private static final Log log = LogFactory.getLog(Device.class);
	private final ProviderConfiguration provider = ProviderConfiguration.getProvider();

}
