package com.revature.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/HelloWorld.feature" }, 
		glue = { "com.revature.stepImplementations" }
		)
public class JUnitRunner {

}
 