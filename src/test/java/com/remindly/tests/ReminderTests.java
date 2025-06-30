package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

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
        app.getReminder().tapOnDataField();
        app.getReminder().swipeToMonth("future","AUG",2);
        app.getReminder().selectDate(15);
        app.getReminder().selectYear("future","2027");
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("16/8/2027"));

    }

    @Test
    public void addTimePositiveTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterTitle("Holiday");
        app.getReminder().tapOnTimeField();
        app.getReminder().selectTime("am",545,1301,545,807);
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("6:00"));

    }

    @Test
    public void addRepeatTest(){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterTitle("Holiday");
        app.getReminder().repeatOff();
        app.getReminder().saveReminder();
        Assert.assertTrue(app.getMainScreen().isRepeatOffPresent().contains("Repeat Off"));


    }

    @Test
    public void addRepetitionInterval (){
        app.getMainScreen().tapOnAddReminder();
        app.getReminder().enterTitle("Holiday");
        app.getReminder().repetiotionInterval();
        app.getReminder().enterNumber("5");
        app.getReminder().tapOnOk();
        app.getReminder().saveReminder();

        Assert.assertTrue(app.getMainScreen().isRepeatOffPresent().contains("5"));

    }
}
