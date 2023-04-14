package com.android.common;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver driver=null;
	
	public BaseClass() {
		//init();
		
	}
	
	@BeforeSuite
	public static void init() {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	       
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
       
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");//Version is number here
       
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
       
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//now_in_android.apk");
		try {
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void waitforPageToLoad() {
		
	}
	
	public void waitForElementToPresent(String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void waitforElementToVisible(String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void swipeToElement(String elementText) {
		//driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable().instance(true))"+".scrollIntoView(new UiSelector()"+".textMatches(/"+"elementText"+"\").instance(0))"));
		WebElement element;
		try {
			element=driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+
							   "new UiSelector().text(\""+elementText+
							   "\").instance(0))"));
		} catch (Exception e) {
			element=driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+
					   "new UiSelector().text(\""+elementText+
					   "\").instance(0))"));
		}
		
		
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	
	public void navigateBack() {
		driver.navigate().back();
	}
}
