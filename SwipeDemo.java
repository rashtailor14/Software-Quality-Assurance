import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeDemo extends Basics1{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();
		//Put implicit timeout so that system wont break before this time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//3. Swipe gesture using TouchAction class\
		((FindsByAndroidUIAutomator<AndroidElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
			
		//Longpress on element for 2 sec - move to another element- and release
		TouchAction t = new TouchAction(driver);
		WebElement first = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement second = driver.findElement(By.xpath("//*[@content-desc='45']"));
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
		
	}

}
