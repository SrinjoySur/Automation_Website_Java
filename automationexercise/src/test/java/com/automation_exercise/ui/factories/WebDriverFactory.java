package com.automation_exercise.ui.factories;

import com.automation_exercise.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automation_exercise.constants.ConstantsProvider.LT_ACCESS_KEY;
import static com.automation_exercise.constants.ConstantsProvider.LT_USERNAME;
public class WebDriverFactory {
    private static WebDriverFactory instance;
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    public static void setThreadLocalDriver(String browser) throws MalformedURLException {
        threadLocalDriver.set(getInstance().getDriver(browser));
    }

    public static void quitDriverAndRemove() {
        getThreadLocalDriver().quit();
        threadLocalDriver.remove();
    }

    private WebDriverFactory() {}

    private synchronized static WebDriverFactory getInstance() {
        if (instance == null){
            return instance = new WebDriverFactory();
        }
        return instance;
    }

    private WebDriver getDriver(String browser) throws MalformedURLException {
        String hub = "@hub.lambdatest.com/wd/hub";
        return switch (browser){
            case "CHROME" -> new RemoteWebDriver(new URL("https://"+LT_USERNAME+":"+ LT_ACCESS_KEY + hub), (ChromeOptions) OptionFactory.getOptions(browser));
            case "EDGE" -> new RemoteWebDriver(new URL("https://"+LT_USERNAME+":"+ LT_ACCESS_KEY + hub),(EdgeOptions) OptionFactory.getOptions(browser));
            case "FIREFOX" -> new RemoteWebDriver(new URL("https://"+LT_USERNAME+":"+ LT_ACCESS_KEY + hub),(FirefoxOptions) OptionFactory.getOptions(browser));
            case "SAFARI" -> new RemoteWebDriver(new URL("https://"+LT_USERNAME+":"+ LT_ACCESS_KEY + hub),(SafariOptions) OptionFactory.getOptions(browser));
            default -> throw new DriverNotFoundException("No such Browser is not available");
        };
    }
}
