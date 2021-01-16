import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {

	public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub

		File f = new File("src");
		File fs = new File(f,"ApiDemos-debug.apk");
		
		//Android updated its internal framework to uiautomator2 and through Appium code, 
		//we need to tell that we need to access uiautomator2 elements of Android.
		DesiredCapabilities dc = new DesiredCapabilities();
		
		if(device.equals("emulator"))
		{
			dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Rashmi_Emulator");
		}
		else if(device.equals("real"))
		{
			dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomator2");
		
		
		dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		
		//Driver object is responsible to execute automation test scripts in android
		//This will form connection to appium server 
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
