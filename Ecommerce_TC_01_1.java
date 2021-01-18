import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC_01_1 extends Basics1{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//For The toast message to appear I have to leave the name field empty. So I am not writing that code.
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
		driver.findElementByXPath("//*[@text='Australia']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//Toast message is nothing but the error, when u leave any field empty it will give u error. Its called Toast message
		//If the Toast message is not fetched by UIAutomator then Android has a class for tht
		//Here Get attribute name is fetching the message appear in Toast message
		String ToastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(ToastMessage);
		//Actual Validation: Here I am comparing Actual result with expected result.
		Assert.assertEquals("Please enter your name",ToastMessage);
	}

}
