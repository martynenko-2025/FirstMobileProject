package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReminderTests extends TestBase{

    @Test
    public void addTitlePositiveTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterTitle("Holiday");
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().getRecycleTitle().contains("Holiday"));
    }

    @Test
    public void addDataPisitiveTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterTitle("Holiday");
//        app.getReminder().tapOnDataField;
//        app.getReminder().swipeToMonth("future","AUGUST");
//        app.getReminder().selectDate("");
//        app.getReminder().selectYear("Future","2027");
//        app.getReminder().tapOnOk;
//        app.getReminder().saveReminder();
//
//        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("16/08/2027"));

    }
}
