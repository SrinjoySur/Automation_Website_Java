package com.automation_exercise.hooks;

import com.automation_exercise.constants.ConstantsProvider;
import com.automation_exercise.ui.factories.WebDriverFactory;
import com.automation_exercise.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.automation_exercise.ui.factories.WebDriverFactory.getThreadLocalDriver;
import static com.automation_exercise.ui.factories.WebDriverFactory.setThreadLocalDriver;
import static com.automation_exercise.utils.ScreenshotUtils.saveScreenshot;


public class WebDriverHook {
    ConfigReader configReader = ConfigReader.getInstance();

    @Before
    public void setUp() throws MalformedURLException {
        String browser = configReader.getProperty("browser").toUpperCase();
        setThreadLocalDriver(browser);
        getThreadLocalDriver().manage().window().maximize();
    }

    @SneakyThrows
    @After(order = 1)
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
                saveScreenshot(getThreadLocalDriver(),scenario.getName());
                try(InputStream is= Files.newInputStream(Paths.get(ConstantsProvider.screenshotsDirPath+"/failure"+scenario.getName()+"_screenshot.png"))){
                    Allure.addAttachment(scenario.getName()+"_failed.png",is);
                }
            }
    }
    @After(order = 0)
    public void tearDown(){
        WebDriverFactory.quitDriverAndRemove();
    }

    public static WebDriver getDriver() {
        if (getThreadLocalDriver() == null) {
            throw new IllegalStateException("WebDriver is not initialized. Make sure setUp() is executed before calling getDriver().");
        }
        return getThreadLocalDriver();
    }
}
