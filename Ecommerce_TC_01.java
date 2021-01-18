import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC_01 extends Basics1 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		//Scenario 1: Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Rashmi");
		//When you enter something using keyboard, We have to hide the keyboard to see next element
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
		driver.findElementByXPath("//*[@text='Australia']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}

}
