package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class BaseHelper{
    AppiumDriver driver;

    TouchAction touchAction;
    public BaseHelper(AppiumDriver driver){
        this.driver = driver;
        touchAction = new TouchAction<>((PerformsTouchActions)driver);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

        driver.navigate().back();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String isTextPresent(By locator) {
        return driver.findElement(locator).getText();
    }

    public void swipe(double start, double stop){
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * start);
        int stopY= (int) (size.getHeight() * stop);

        touchAction.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x,stopY))
                .release().perform();

    }
    public void swipeInElement(By locator, double start, double stop){
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.getHeight() * start);
        int stopY= (int) (size.getHeight() * stop);
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();
        int middleX = (leftX + rightX)/2;

        touchAction.longPress(PointOption.point(middleX,startY))
                .moveTo(PointOption.point(middleX,stopY))
                .release().perform();
    }
    public void tapWithCoordinates(int x, int y){
        touchAction.tap(PointOption.point(x,y))
                .release().perform();
    }
}

