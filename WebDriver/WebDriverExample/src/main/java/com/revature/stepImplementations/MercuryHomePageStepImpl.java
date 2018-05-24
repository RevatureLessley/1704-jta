package com.revature.stepImplementations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.driver.DriverFactory;
import com.revature.pom.FlightFinderPage;
import com.revature.pom.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MercuryHomePageStepImpl {
	
	WebDriver driver;
	HomePage home;
	FlightFinderPage flight;

	@Given("^a user opens a web browser$")
	public void a_user_opens_a_web_browser() throws Throwable {
		driver = DriverFactory.getDriver("chrome");
	}

	@Given("^navigates to the Mercury Tours website$")
	public void navigates_to_the_Mercury_Tours_website() throws Throwable {
	    home = new HomePage(driver);
	    assertEquals("Welcome: Mercury Tours", home.getPageTitle());
	}

	@When("^a user inputs their \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_user_inputs_their_and(String arg1, String arg2) throws Throwable {
		home.usernameField().sendKeys(arg1);
		home.passwordField().sendKeys(arg2);
	}

	@When("^clicks the sign in button$")
	public void clicks_the_sign_in_button() throws Throwable {
	    home.signInButton().click();
	}

	@Then("^a user sees the Flight Reservation Page$")
	public void a_user_sees_the_Flight_Reservation_Page() throws Throwable {
		flight = new FlightFinderPage(driver);
	    assertEquals("Find a Flight: Mercury Tours:", flight.getPageTitle());
	}
	
	@Given("^(\\d+) passengers depart from \"([^\"]*)\"$")
	public void passengers_depart_from(int arg1, String arg2) throws Throwable {
		flight.numberOfPassengersDropdown(arg1);
		flight.flightFinderDropdown(arg2, "fromPort");
	}

	@Given("^the passengers leave \"([^\"]*)\" (\\d+)$")
	public void the_passengers_leave(String arg1, int arg2) throws Throwable {
	    flight.flightFinderDropdown(arg1, "fromMonth");
	    flight.flightFinderDropdown(String.valueOf(arg2), "fromDay");
	}

	@Given("^the passengers arrive in \"([^\"]*)\"$")
	public void the_passengers_arrive_in(String arg1) throws Throwable {
	    flight.flightFinderDropdown(arg1, "toPort");
	}

	@Given("^the passengers return \"([^\"]*)\" (\\d+)$")
	public void the_passengers_return(String arg1, int arg2) throws Throwable {
	    flight.flightFinderDropdown(arg1, "toMonth");
	    flight.flightFinderDropdown(String.valueOf(arg2), "toDay");
	}

	@When("^the passengers choose \"([^\"]*)\" on \"([^\"]*)\"$")
	public void the_passengers_choose_on(String arg1, String arg2) throws Throwable {
	    flight.businessClassRadio().click();
	    flight.flightFinderDropdown(arg2, "airline");
	    flight.findFlightsButton().click();
	}

	@Then("^the passengers see the proper information$")
	public void the_passengers_see_the_proper_information() throws Throwable {
	    assertEquals("Select a Flight: Mercury Tours", driver.getTitle());
	}

	@After
	public void shutDownDrivers() {
		driver.quit();
	}
	
}
