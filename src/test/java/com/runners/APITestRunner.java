package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/APITesting.feature"},
        glue = {"com.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports",
        		  "json:target/cucumber.json"},
        tags={"@APITest"},
		monochrome = true
)
public class APITestRunner {
	
}