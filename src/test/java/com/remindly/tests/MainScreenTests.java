package com.remindly.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{

    @Test
    public void appLaunchTest(){
        Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());

    }
    @Test
    public void licenses(){
        app.getMainScreen().tapOnLicenses();
        Assert.assertTrue(app.getMainScreen().getLicensesText().contains("Licenses"));

    }
}
