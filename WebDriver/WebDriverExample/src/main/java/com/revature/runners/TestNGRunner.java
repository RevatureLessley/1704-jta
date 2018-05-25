package com.revature.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
			features= {"src/test/MercuryHomePage.feature"},
			glue = {"com.revature.stepImplementations"}
		)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}