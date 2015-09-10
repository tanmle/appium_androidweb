package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



/**
 * The instance element brings together all of the testbed components to fully define everything
 * That a test needs to execute.
 *
 */
public class DataInstanceConfiguration extends DataConfiguration
{
    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }
    
    public String getDevicePlatform()
    {
        return devicePlatform;
    }

    public void setDevicePlatform(String devicePlatform)
    {
        this.devicePlatform = devicePlatform;
    }
    
    public String getURL()
    {
        return url;
    }

    public void setURL(String url)
    {
        this.url = url;
    }
    
    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }
    
    public String getAppiumURL()
    {
        return appiumURL;
    }

    public void setAppiumURL(String appiumURL)
    {
        this.appiumURL = appiumURL;
    }
    @Override
    public Element toElement(Document document) 
    {
        Element instance = document.createElement("customer");
        instance.setAttribute("tag", getTag());
        
        Element browser = document.createElement("browser");
        browser.setTextContent(getBrowser());
        instance.appendChild(browser);
        
        Element url = document.createElement("url");
        url.setTextContent(getURL());
        instance.appendChild(url);
        
        Element dvName = document.createElement("deviceName");
        dvName.setTextContent(getDeviceName());
        instance.appendChild(dvName);
        
        Element dvPlatform = document.createElement("devicePlatform");
        dvPlatform.setTextContent(getDevicePlatform());
        instance.appendChild(dvPlatform);
        
        Element appiURL = document.createElement("appiumURL");
        appiURL.setTextContent(getAppiumURL());
        instance.appendChild(appiURL);
        
        return instance;
    }

    @Override
    public void fromElement(XmlHelper xml, Element base)
    {
        setTag(base.getAttribute("tag"));
        setBrowser(xml.getText(base, "browser"));  
        setURL(xml.getText(base,"url"));
        setDeviceName(xml.getText(base,"deviceName"));
        setDevicePlatform(xml.getText(base,"devicePlatform"));
        setAppiumURL(xml.getText(base,"appiumURL"));
       
        
    }

	private String deviceName,
	devicePlatform,appiumURL,url,browser;
 
   
}
