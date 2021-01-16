import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Browser extends BasicsChrome{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
	
		//IN MOBILE BROWSER SCROLL DOWN SYNTEX IS NOT USING APPIUM OR SELENIUM
		//IT USES JAVASCRIPTEXECUTOR to Achiever Scrolldown functionality
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,480)","");
		//Assert.assertTrue statement is checking the sttement whether it is true or not.
		// The below code is scrolling down until it sees the class which contains header: Top stories.
		Assert.assertTrue(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header"));
		
	}

}
