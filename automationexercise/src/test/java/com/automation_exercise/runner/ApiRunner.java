package com.automation_exercise.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/api"},
        glue = {"com.automation_exercise.api.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failedrerun.txt"},
        tags = "not @Skip"
)
public class ApiRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}