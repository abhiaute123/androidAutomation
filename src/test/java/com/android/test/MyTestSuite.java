package com.android.test;

import org.testng.annotations.Test;

import com.android.common.BaseClass;
import com.android.pages.HomePage;
import com.android.pages.InterestPage;
import com.android.pages.SettingsPage;

public class MyTestSuite extends BaseClass{

	@Test
	public void TC001() {
		HomePage homePage=new HomePage();
		homePage.verifyPageTitle("Now in Android");
		
		homePage.clickOnSettings();
		
		SettingsPage settingPage=new SettingsPage();
		settingPage.verifySystemDefaultIsSelected();
		
		settingPage.verifyAvailableDarkModePreferences();
		settingPage.selectDarkModePreference("Dark");
		settingPage.clickOKButton();
		homePage.waitforPageToLoad();
		
		homePage.clickOnMenu("Interests");
		InterestPage interestPage=new InterestPage();
		interestPage.verifyInterestPageIsOpened();
		interestPage.selectInterestMenu("Games");
		interestPage.clickFollowUnfollowCheckBox("NOT FOLLOWING");
		navigateBack();
		
		interestPage.verifyInterestIsChecked("Games");
		
	}
}
