package com.automation_exercise.ui.base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.automation_exercise.hooks.WebDriverHook.getDriver;

public abstract class BasePage {

    protected WebDriver driver;
    public WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Defining explicit wait in constructor itself
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void getImplicitlyWait(int durations) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(durations));
    }

    public Wait<WebDriver> getWebDriverWait(int durations) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(durations));
    }

    public Wait<WebDriver> getFluentWait(int durations, int poll) {
        return new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(durations)).pollingEvery(Duration.ofSeconds(poll)).ignoring(TimeoutException.class);
    }

//    public String verifyUrl() {
//        waitUntilUrlToBe("https://frontend-run8-1-team5-frontend-dev.development.krci-dev.cloudmentor.academy/login");
//        return getCurrentUrl(getDriver());
//    }

    /**
     * Overriding default implementation of findElement with Explicit wait addon
     * This way, there is no need to declare WebDriverWait in derived classes.
     * Hence, removes the overhead of utility class and improves code readability.
     */

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitUntilUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
}