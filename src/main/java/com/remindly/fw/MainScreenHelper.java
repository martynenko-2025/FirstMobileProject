package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper{

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public void confirm() {
        tap(By.id("android:id/button1"));
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("no_reminder_text"));
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public String getRecycleTitle() {
        return isTextPresent(By.id("recycle_title"));
    }


    public boolean isLicensesTextPresent() {
        return isElementPresent(By.id("licenses_text_view"));
    }

    public void tapOnLicenses() {
        tap(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"));
        tap(By.id("title"));
    }
}
