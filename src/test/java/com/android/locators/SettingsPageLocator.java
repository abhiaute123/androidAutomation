package com.android.locators;

public interface SettingsPageLocator {

	public static String MODE_PREFERNCES="//android.widget.TextView[@text='Dark mode preference']//following-sibling::android.view.View[1]//android.widget.TextView";
	public static String MODE="//android.widget.TextView[@text='%s']/..//android.widget.RadioButton";
	public static String OK_BUTTON="//android.widget.TextView[@text='OK']";
}
