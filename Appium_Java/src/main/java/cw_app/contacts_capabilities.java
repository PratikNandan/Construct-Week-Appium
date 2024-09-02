package cw_app;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidElement;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


public class contacts_capabilities {
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "My_Emulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.example.android.contactmanager");
		//io.appium.android.apis.ApiDemos - API Demos
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.android.contactmanager.ContactManager");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
		
		
	}

}
