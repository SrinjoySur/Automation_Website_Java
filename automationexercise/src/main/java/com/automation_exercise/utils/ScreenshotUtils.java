package com.automation_exercise.utils;

import com.contact_list.constants.ConstantsProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    private static volatile TakesScreenshot screenshot;

    public static void saveScreenshot(WebDriver driver,String name) throws IOException {
        screenshot = (TakesScreenshot) driver;
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(ConstantsProvider.screenshotsDirPath + "/failure" + name + "_screenshot.png");
        FileHandler.copy(srcFile, destFile);
    }
}
