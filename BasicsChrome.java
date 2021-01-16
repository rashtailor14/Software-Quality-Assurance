import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasicsChrome {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		//TO AUOTMATE MOBILE BROWSER WE NEED SELENIUM, REAL DEVICE IS CONNECTED AND TO RUN TEST ON BROWSER WE 
		// DO NOT NEED FILE INFORMATION, SO WE ARE COMMENTING THAT.
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//TO INVOKE CHROME BROWSER IN MOBILE BROWSER
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		dc.setCapability("chromedriverExecutable", "/Users/rashm/AppData/Roaming/npm/node_modules/appium/node_modules/appium-chromedriver/chromedriver/win/chromedriver.exe");
		
				AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
				
	}

}
