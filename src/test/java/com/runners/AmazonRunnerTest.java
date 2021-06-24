package com.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/AmazonBookPriceTest.feature"},
        glue = {"com.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports",
        		  "json:target/cucumber.json"},
        tags={"@UI","@UITest"},
		monochrome = true
)
public class AmazonRunnerTest {
	
}