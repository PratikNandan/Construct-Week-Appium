package cw_App;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cw_app.contacts_capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//static import
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class contacts extends contacts_capabilities {
	AndroidDriver<AndroidElement> driver;
	
	ExtentHtmlReporter htmlreporter;
	ExtentReports extnt;
	ExtentTest test;
	
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		htmlreporter = new ExtentHtmlReporter("extent.html");
		extnt = new ExtentReports();
		extnt.attachReporter(htmlreporter);

		
	}
	
	

	
	@Test(priority = 2)
	public void OtherOperations() {       //add contact
		driver.findElement(MobileBy.AccessibilityId("Add Contact")).click();
		// Enter Name 
		driver.findElement(MobileBy.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("Gojo Saturo ");
		//dropdown phone type
		driver.findElement(MobileBy.id("com.example.android.contactmanager:id/contactPhoneTypeSpinner")).click();
		//select work
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[2]")).click();
		
		//dropdown email type
		driver.findElement(MobileBy.id("com.example.android.contactmanager:id/contactEmailTypeSpinner")).click();
		//select work
		driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[3]")).click();
				
		
		
		driver.findElement(MobileBy.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("856445289");
		
		driver.findElement(MobileBy.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("gojo@gmail.com");
		
		driver.findElement(MobileBy.AccessibilityId("Save")).click();
        test.info("Performed other operations");

		
		
		}
	
	@Test(priority = 1)
	public void Click() throws InterruptedException {
		test = extnt.createTest("Extent Test Report");

		driver.findElement(MobileBy.AccessibilityId("Show Invisible Contacts (Only)")).click();
		Thread.sleep(4000);

		driver.findElement(MobileBy.AccessibilityId("Show Invisible Contacts (Only)")).click();
        test.info("Performed click operations");

	}
	
	@Test(priority = 3)
	public  void PowerSaver() throws InterruptedException {     //power saver
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		Thread.sleep(4000);
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		driver.navigate().back();
        test.info("Performed PowerSaver operation");

		
	}
	
	@Test(priority = 4)
	public void Copy() {
		
		driver.activateApp("com.google.android.apps.messaging");
		
		//String out = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Why so serious\")")).getText();
		AndroidElement elem = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet"));
		String output = elem.getText();
		System.out.println(output);
		
		driver.activateApp("com.example.android.contactmanager");
        test.info("Performed Switch and Copy operations");
        
        extnt.flush();
	
	}




}
