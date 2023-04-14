package com.android.locators;

public interface InterestPageLocator {

	public static String PAGE_TITLE="//android.widget.TextView[@text='Interests']";
	public static String MENU_ITEM="//android.widget.TextView[@text='%s']";
	public static String FOLLOW_UNFOLLOW_CHECKBOX="//android.widget.TextView[@text='%s']/..//android.widget.CheckBox";

	public static String CHECKED_INTEREST="//android.widget.TextView[@text='%s']/..//following-sibling::android.view.View[1]";
}
