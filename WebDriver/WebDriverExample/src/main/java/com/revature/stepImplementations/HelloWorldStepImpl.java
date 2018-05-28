package com.revature.stepImplementations;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloWorldStepImpl {
	
	Calculator calculator;
	int result;
	boolean illegalArgumentExceptionThrown;

	@Given("^a user powers up the calculator$")
	public void a_user_powers_up_the_calculator() throws Throwable {
	    calculator = new Calculator();
	}

	@When("^a user adds (\\d+) and (\\d+)$")
	public void a_user_adds_and(int arg1, int arg2) throws Throwable {
		result = calculator.add(arg1, arg2);
	}
	
	@When("^a user subtracts (\\d+) from (\\d+)$")
	public void a_user_subtracts_from(int arg1, int arg2) throws Throwable {
	    result = calculator.subtract(arg1, arg2);
	}
	
	@When("^a user multiplies (\\d+) by (\\d+)$")
	public void a_user_multiplies_by(int arg1, int arg2) throws Throwable {
	    result = calculator.multiply(arg1, arg2);
	}
	
	@When("^a user divides (\\d+) by (\\d+)$")
	public void a_user_divides_by(int arg1, int arg2) throws Throwable {
		try {
			result = calculator.divide(arg1, arg2);
		} catch (IllegalArgumentException iae) {
			illegalArgumentExceptionThrown = true;
		}
	}

	@Then("^an IllegalArgumentException is thrown$")
	public void an_IllegalArgumentException_is_thrown() throws Throwable {
	    assertTrue(illegalArgumentExceptionThrown);
	    illegalArgumentExceptionThrown = false;
	}

	@Then("^a user sees (\\d+)$")
	public void a_user_sees(int arg1) throws Throwable {
		assertEquals(result, arg1);
	}
}
