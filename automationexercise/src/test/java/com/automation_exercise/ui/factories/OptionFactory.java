package com.automation_exercise.ui.factories;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;

import static com.automation_exercise.constants.ConstantsProvider.LT_ACCESS_KEY;
import static com.automation_exercise.constants.ConstantsProvider.LT_USERNAME;

public class OptionFactory {

    public static Object getOptions(String browser) {
        switch (browser) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                chromeOptions.addArguments("--headless");
                chromeOptions.setCapability("LT:OPTIONS",browserCapabilities());
                return chromeOptions;
            case "FIREFOX":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                firefoxOptions.setCapability("LT:OPTIONS",browserCapabilities());
                return firefoxOptions;
            case "EDGE":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                //edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--headless");
                edgeOptions.setCapability("LT:OPTIONS",browserCapabilities());
                return edgeOptions;
            case "SAFARI":
                SafariOptions safariOptions = new SafariOptions();
                return safariOptions;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
    }
    public static HashMap<String,Object> browserCapabilities(){
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("browserVersion", "dev");
        ltOptions.put("build", "Contact List Test");
        ltOptions.put("username", LT_USERNAME);
        ltOptions.put("accessKey", LT_ACCESS_KEY);
        ltOptions.put("project", "ContactList");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        return ltOptions;
    }
}