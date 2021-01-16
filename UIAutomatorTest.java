/*
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorTest extends Basics1{

	public static void main(String[] args) throws MalformedURLException{

		
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		// If you want to find element from Android UIAutomator, Then follow this syntax:
		// driver.findElementByAndroidUIAutomator("attribute(\"value\)")
		// In Java when you write "" inside "" , you have to add \ before ". 
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		//Validate clickable feature for all options
		
		
		((FindsByAndroidUIAutomator<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		}
		
}
*/