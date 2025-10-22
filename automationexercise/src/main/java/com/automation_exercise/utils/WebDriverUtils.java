package com.automation_exercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverUtils {

    public static void click(WebElement element) {
        element.click();
    }

    public static void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public static void waitForVisibility(Wait wait, WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}