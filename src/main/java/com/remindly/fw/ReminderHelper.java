package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReminderHelper extends BaseHelper {


    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        type(By.id("reminder_title"), title);
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnDataField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, String month, int number) {
        pause(1000);

        if (!getSelectedMonth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.7, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }

    private String getSelectedMonth() {
        return isTextPresent(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();
    }

    public void selectYear(String period, String year) {
        tap(By.id("date_picker_year"));
        pause(500);
        if (!getSelectedYear().equals(year)){
            if (period.equals("future")) {
                swipeUnitNeededYear(year, 0.55, 0.5);
            }else if (period.equals("past")){
                swipeUnitNeededYear(year, 0.5, 0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUnitNeededYear(String year, double start, double stop) {
        while (!getYear().equals(year)) {
            swipeInElement(By.className("android.widget.ListView"), start, stop);
        }
        getYear();
    }

    private String getYear() {
       return isTextPresent(By.id("month_text_view"));
    }

    private String getSelectedYear() {
        return isTextPresent(By.id("date_picker_year"));
    }

    public void tapOnOk() {
        tap(By.xpath("//*[@text='OK']"));
    }

    public void tapOnTimeField() {
        tap(By.id("time"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {
        pause(500);

        if (timeOfDay.equals("am")) {
            tapWithCoordinates(306, 1422);
        }else if(timeOfDay.equals("pm")){
            tapWithCoordinates(784,1422);
        }
        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }

    public void repeatOff() {
        tap(By.id("repeat_switch"));
    }

    public void repetiotionInterval() {
        tap(By.id("repeat_no_text"));
    }

    public void enterNumber(String number) {
        type(By.xpath("\t\n" +
                "//android.widget.EditText"), number);
    }
}
