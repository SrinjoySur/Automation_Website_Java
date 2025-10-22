package com.automation_exercise.runner;

import com.automation_exercise.utils.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = {"src/test/resources/features/ui"},
        glue = {"com.automation_exercise.ui.stepdefinitions","com.automation_exercise.api.stepdefinitions","com.automation_exercise.hooks"},
        plugin = {"pretty", "html:target/cucumber","html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failedrerun.txt"},
        tags = "not @Skip",
        monochrome = true
)
public class UiRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters({"Browser"})
    public void defineBrowser(@Optional("CHROME") String browser){
        ConfigReader reader=ConfigReader.getInstance();
        reader.setBrowser(browser);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
