import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basics1 {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
					
		// TODO Auto-generated method stub
		
		//Steps to pull out file information from src folder instead of writing whole path
		File f = new File("src");
		File fs = new File(f,"General-Store.apk");
		
		//Android updated its internal framework to uiautomator2 and through Appium code, 
		//we need to tell that we need to access uiautomator2 elements of Android.
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.VERSION, "11.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Emulator_1");
		//dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Uiautomator2");
				
		dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		
		//Driver object is responsible to execute automation test scripts in android
		//This will form connection to appium server 
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
				
	}

}
