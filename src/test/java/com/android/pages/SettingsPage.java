package com.android.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.common.BaseClass;
import com.android.locators.HomePageLocator;
import com.android.locators.SettingsPageLocator;

public class SettingsPage extends BaseClass implements SettingsPageLocator{

	
	
	@FindBy(xpath=MODE_PREFERNCES)
	private List<WebElement> preferences;
	
	@FindBy(xpath=OK_BUTTON)
	private WebElement okButton;
	
	
	
	public SettingsPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	
	
	public void verifySystemDefaultIsSelected() {
		waitForPageLoad();
		swipeToElement("System default");
		WebElement element=driver.findElement(By.xpath("//android.widget.TextView[@text='System default']/.."));
				assertEquals(element.getAttribute("checked"),"true");
	}
	
	public void verifyAvailableDarkModePreferences() {
		List<String> modes=Arrays.asList("System default","Dark","Light");
		waitForElementToPresent(MODE_PREFERNCES);
		for(WebElement element:preferences) {
			swipeToElement(element.getText());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			assertTrue(modes.contains(element.getText()));
		}
	}
	
	public void selectDarkModePreference(String mode) {
		swipeToElement(mode);
		WebElement element=driver.findElement(By.xpath(String.format(MODE, mode)));
		element.click();
		System.out.println();
	}
	
	public void clickOKButton() {
		okButton.click();
	}
	
	public void waitForPageLoad() {
		waitForElementToPresent(OK_BUTTON);
		waitforElementToVisible(OK_BUTTON);
	}
	
}
