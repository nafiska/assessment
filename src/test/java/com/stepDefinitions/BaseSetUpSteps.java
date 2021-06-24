package com.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import pages.custombdd.pages.WebDriverManager;

public class BaseSetUpSteps {

	private static Logger Log = Logger.getLogger(BaseSetUpSteps.class);
	public WebDriver driver;
	public WebDriverManager webDriverManager;

	@Before("@UI")
	public void before(Scenario scenario) throws Throwable {
		Log.info("Cucumber - Before Tag");
		webDriverManager = new WebDriverManager();
		String browserName = "chrome";
		driver = webDriverManager.getDriver(browserName);
	}

	@After("@UI")
	public void after(Scenario scenario) throws Throwable {
		Log.info("Cucumber - After Tag");
		webDriverManager.closeDriver(scenario);
	}

}