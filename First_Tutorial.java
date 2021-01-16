import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class First_Tutorial extends Basics1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		// TODO Auto-generated method stub
		//I have derived capabilities method from basics1 class.
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Using xpath we can identify the postion of the element 
		//Xpath syntex: //tagname[@attribute='value']
		// the tag name in android can be Class name from UIautomator Viewer
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		// When class name is also not unique, Then u can provide the class name with index of what position needs to click
		// Syntex will be: //tagname[index position]
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//If you want to enter something in the textview you have to execute .sendkeys() method instead of .click()
		driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
		//When only class name is available: You can search by findElementsByClassName.get(index position).Click()
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		Thread.sleep(1000);
	}

}
