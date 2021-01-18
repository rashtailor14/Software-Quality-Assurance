import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_TC_04 extends Basics1 {

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
		
		//Now we are checking total of 2 products matches with final total or not
		//We can find product price elements by id and grab 0 index and get text.
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		//Output I will get is $160.97
		//I want out put in double so that i can perform addition of both values
		//below code will take the data from index 1. so it will remove $ sign. 
		amount1= amount1.substring(1);
		//Output of above line will be 160.97
		// Still its a string. so we have to convert it into double
		double amount1Value = Double.parseDouble(amount1);
		//Same with amount 2
		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		amount2 = amount2.substring(1);
		double amount2Value = Double.parseDouble(amount2);
		//Sum
		double sumOfProducts = amount1Value+amount2Value;
		System.out.println(sumOfProducts+" is Sum of Products");
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue+" is The total expected value");
		Assert.assertEquals(sumOfProducts, totalValue);
		
		
	}

}
