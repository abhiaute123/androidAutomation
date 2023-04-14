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
import com.android.locators.InterestPageLocator;
import com.android.locators.SettingsPageLocator;

public class InterestPage extends BaseClass implements InterestPageLocator{

	@FindBy(xpath = PAGE_TITLE)
	private WebElement pageTitle;
	
	public InterestPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyInterestPageIsOpened() {
		waitforElementToVisible(PAGE_TITLE);
		assertEquals(pageTitle.getText(), "Interests");
	}
	
	public void selectInterestMenu(String menuName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		swipeToElement(menuName);
		driver.findElement(By.xpath(String.format(MENU_ITEM, menuName))).click();
	}
	
	public void clickFollowUnfollowCheckBox(String name) {
		waitforElementToVisible(String.format(FOLLOW_UNFOLLOW_CHECKBOX, name));
		driver.findElement(By.xpath(String.format(FOLLOW_UNFOLLOW_CHECKBOX, name))).click();
	}
	
	public void verifyInterestIsChecked(String interestName) {
		swipeToElement(interestName);
		WebElement element=driver.findElement(By.xpath(String.format(CHECKED_INTEREST, interestName)));
		assertEquals(element.getAttribute("checked"), "true");
	}

}
