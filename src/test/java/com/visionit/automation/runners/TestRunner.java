package com.visionit.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="com.visionit.automation.stepdefs",
		tags="@SelectProductSize",
		plugin = {"pretty",
				"html:target/htmlreport.html",
				"json:target/json/fiExpectedTwitterURLe.json",
				},
		monochrome = true,
		publish=true,
		dryRun=false
		
		)


public class TestRunner {

}
