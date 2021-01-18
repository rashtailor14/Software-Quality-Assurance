import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Ecommerce_TC_04_CodeOptimize extends Basics1 {

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
		
		//Scenario 4: Validate the total amount displayed in the checkout page matches the sum of products selected for shopping.
		// Here the class name is same for all the items in cart, and name is also same. 
		// when we findelements by xpath, and put text=add to cart, and index= 0 then it will click the 1st item listed in page, 
		// and when we click add to cart it changes to added to cart. So we have to put index=0 again for 2nd product
		// As after 1st product is added it changes to added to cart. So there is only one product left in the page.
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//After I click on add to cart. It will take some time to navigate to 2nd page.
		//at that time appium can get confuse cz we have amount in page 1 as well as check out page
		// So we will give some sleep time here so that it can redirect to checkout page ane then take a value
		Thread.sleep(4000);
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0;
		for (int i=0; i<count; i++)
		{
			String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
			double amount = getAmount(amount1);
			sum=sum+amount;
		}
		System.out.println(sum+" is Sum of Products");
		
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue+" is The total expected value");
		Assert.assertEquals(sum, totalValue);
		
		//Scenario 5: Validate mobile gestures are working fine for links(long press) and navigate to webview 
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(3))).release().perform();
		driver.findElementByClassName("android.widget.Button").click();
		driver.findElementByXPath("//android.widget.Button[@text='Visit to the website to complete purchase']").click();
	}
	//Here we have made a function which will convert string into double.
	//Function is always written outside public void main
	public static double getAmount(String value)
	{
		value=value.substring(1);
		double amount2value= Double.parseDouble(value);
		return amount2value;
	}
}
