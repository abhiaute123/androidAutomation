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

public class HomePage extends BaseClass implements HomePageLocator{

	@FindBy(xpath=PAGE_TITLE)
	private WebElement pageTitle;
	
	@FindBy(xpath=SETTINGS)
	private WebElement settingIcon;
	
	
	
	public HomePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void verifyPageTitle(String title) {
		assertEquals(pageTitle.getText(), title);
	}
	
	public void clickOnSettings() {
		settingIcon.click();
	}
	
	public void waitForPageLoad() {
		waitForElementToPresent(PAGE_TITLE);
		waitforElementToVisible(PAGE_TITLE);
	}
	
	public void clickOnMenu(String menu) {
		WebElement element=driver.findElement(By.xpath(String.format(MENU, menu)));
		element.click();
	}
	
	
}
