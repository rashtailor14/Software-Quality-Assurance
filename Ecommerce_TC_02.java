import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC_02 extends Basics1 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		//Scenario 2: Shop the items in the app by scrolling to specific product and add to cart
		
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
		
		//Now we have to add an item in the cart. and for that we have to scroll until we see the add cart and product info
		// From the above scroll method we wont be able to achieve that
		// we have to use below method.We have to use parent class(Whole page(List) ID), and then to child class(Product ID)
		//This is Parent class: resourceId(\"com.androidsample.generalstore:id/rvProductList\")
		//This is child class:textMatches(\"Jordan 6 Rings\")
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		
		//Now for Add to cart there is no unique ID or class,
		//Here we are taking one class which has multiple elements. So findElementsById
		// Count will get a size of products listed in a page
		// forloop will start checking the product name if its equal to jordan then it will get its index and click on addcart function.
		// Once the add cart is done we will break the loop
		int count=    driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i=0;i<count;i++)
		{
			String text=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(text.equalsIgnoreCase("Jordan 6 Rings"))  //if(text=="Jordan 6 rings"
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		//Scenario 3: Validate if the items selected in the page 2 are matching with items displayed in checkout page
		
		String LastPageText = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		System.out.println(LastPageText);
		Assert.assertEquals("Jordan 6 Rings", LastPageText );
	}

}
