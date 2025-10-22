package com.automation_exercise.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failedrerun.txt",
        glue = {"com.contact_list.ui.stepdefinitions","com.automation_exercise.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failedrerun.txt"},
        tags = "not @Skip",
        monochrome = true
)
public class FailedTestRerun extends AbstractTestNGCucumberTests {
}
