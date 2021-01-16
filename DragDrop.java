import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends Basics1{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		//5. Drag and Drop Using TouchAction class
		// Here Taking findelementsbyClassName. And by giving them class, we r providing index value in get() function
		TouchAction t = new TouchAction(driver);
		WebElement first = driver.findElementsByClassName("android.view.View").get(0);
		WebElement second = driver.findElementsByClassName("android.view.View").get(1);
		
		t.longPress(longPressOptions().withElement(element(first))).moveTo(element(second)).release().perform();
		
	}

}
