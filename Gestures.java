
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Basics1{

	private static LongPressOptions longpressOptions;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		//Put implicit timeout so that system wont break before this time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//The below code explain how to scroll and select the appropriate element.
		((FindsByAndroidUIAutomator<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		
		//1. Tap Gesture: using TouchAction class
		
		TouchAction t = new TouchAction(driver);
		WebElement expandList = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
		t.tap(tapOptions().withElement(element(expandList))).perform();
		
		
		//2. Longpress gesture using TouchAction class
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement pnames= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		t.longPress(longPressOptions().withElement(element(pnames)).withDuration(ofSeconds(2))).release().perform();
		
		//Validate that Sample menu is displayed after longpress.
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
	
		
	}
	

}
