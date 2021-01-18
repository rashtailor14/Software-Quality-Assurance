import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import java.util.*; 

public class Ecommerce_TC_05 extends Basics1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//After I click on add to cart. It will take some time to navigate to 2nd page.
		//at that time appium can get confuse cz we have amount in page 1 as well as check out page
		// So we will give some sleep time here so that it can redirect to checkout page ane then take a value
		Thread.sleep(4000);
		
		
		//Scenario 5: Validate mobile gestures are working fine for links(long press) and navigate to webview 
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		driver.findElementByXPath("//android.widget.Button[@text='Visit to the website to complete purchase']").click();
		
		//To get the context of the hybrid app we have to follow below steps and then selenium will be used for webview
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName : contexts)
		{
			System.out.println(contextName);
		}
		//Now we have get to Contexts: Native_app & WebView.
		//If you want to perform any operation in browser or web, You will need Selenium instead of Appium.
		//Below code will lets you switch from Native App to web view
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
		//Scenario 6: Verify If user can perform operations on web view and can navigate back to native app if needed
		//You have to create KeyEvent class to press android back key to come back to application form webview
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
}
