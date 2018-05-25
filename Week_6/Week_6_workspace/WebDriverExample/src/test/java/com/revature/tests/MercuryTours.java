package com.revature.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;
import com.revature.pom.FlightFinderPage;
import com.revature.pom.HomePage;

public class MercuryTours {

	WebDriver driver;
	WebDriverWait wait;
	HomePage home;
	FlightFinderPage flight;

	@BeforeSuite
	public void beforeSuite() {
		driver = DriverFactory.getDriver("chrome");
		
		// Maximize the browser window
		driver.manage().window().maximize();

		// Implicitly Wait
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Explicit
		wait = new WebDriverWait(driver, 1);
	}

	@Test(priority = 1)
	public void navigateToMercuryTours() {
		home = new HomePage(driver);
	}

	@Test(priority = 2)
	public void validateNavigation() {
		assertEquals("Welcome: Mercury Tours", home.getPageTitle());
	}

	@Test(priority = 3)
	public void validateUsernameInputElement() {
		assertEquals("text", home.usernameField().getAttribute("type"));
	}

	@Test(priority = 3)
	public void validatePasswordInputElement() {
		assertEquals("password", home.passwordField().getAttribute("type"));
	}

	@Test(priority = 4, enabled = true)
	@Parameters("username")
	public void enterUsername(String username) {
		home.usernameField().sendKeys(username);
	}

	@Test(priority = 4, enabled = true)
	@Parameters("password")
	public void enterPassword(String password) {
		home.passwordField().sendKeys(password);
	}
	
	@Test(priority = 4, dataProvider = "credentials", enabled = false)
	public void enterCredentialsIntoUsernameAndPassword (String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}

	@Test(priority = 5)
	public void clickSignIn() {
		home.signInButton().click();
	}
	
	@Test(priority = 6)
	public void validateFlightFinderPage() {
		flight = new FlightFinderPage(driver);
		assertEquals("Find a Flight: Mercury Tours:", flight.getPageTitle());
	}
	
	@Test(priority = 7)
	public void clickRoundTrip() {
		flight.roundTripRadioBtn();
	}
	
	@Test(priority = 8)
	public void clickOneWay() {
		flight.onewayTripRadioBtn();
	}
	
	@Test(priority = 9)
	public void selectFourPassengers() {
		flight.numberOfPassengersDropdown(4);
	}

	@Test(priority = 9)
	public void selectThreePassengers() {
		flight.numberOfPassengersDropdown(3);
	}

	@Test(priority = 9)
	public void selectTwoPassengers() {
		flight.numberOfPassengersDropdown(2);
	}

	@Test(priority = 9)
	public void selectOnePassengers() {
		flight.numberOfPassengersDropdown(1);
	}
	
	@Test(priority = 10, expectedExceptions = {IllegalArgumentException.class})
	public void selectBelowPossiblePassengers() {
		flight.numberOfPassengersDropdown(0);
	}

	@Test(priority = 10, expectedExceptions = {IllegalArgumentException.class})
	public void selectAbovePossiblePassengers() {
		flight.numberOfPassengersDropdown(5);
	}

	@Test(priority = 11, dataProvider = "fromPort")
	public void selectLocationToDepartFrom(String location) {
		flight.flightFinderDropdown(location, "fromPort");
	}
	
	@Test(priority = 12, dataProvider = "invalidPort", expectedExceptions = {IllegalArgumentException.class})
	public void selectInvalidLocationToDepartFrom(String location) {
		flight.flightFinderDropdown(location, "fromPort");
	}
	
	@Test(priority = 13, dataProvider = "months")
	public void selectDepartureMonth(String month) {
		flight.flightFinderDropdown(month, "fromMonth");
	}

	@Test(priority = 13, dataProvider = "invalidMonths", expectedExceptions = {IllegalArgumentException.class})
	public void selectInvalidDepartureMonth(String month) {
		flight.flightFinderDropdown(month, "fromMonth");
	}

	@Test(priority = 14, dataProvider = "days")
	public void selectDepartureDay(String day) {
		flight.flightFinderDropdown(day, "fromDay");
	}
	
	@Test(priority = 15, dataProvider = "fromPort")
	public void selectArrivalLocation(String location) {
		flight.flightFinderDropdown(location, "toPort");
	}
	
	@Test(priority = 15, dataProvider = "months")
	public void selectArrivalMonths(String month) {
		flight.flightFinderDropdown(month, "toMonth");
	}
	
	@Test(priority = 15, dataProvider = "days")
	public void selectArrivalDay(String day) {
		flight.flightFinderDropdown(day, "toDay");
	}

	
	
	
	
	
	
	
	
	
	@DataProvider(name = "days")
	public Object[][] getDays(){
		Object[][] objects = new Object[31][];
		for (int i = 1; i <= 31; i++) {
			objects[i-1] = new Object[] {String.valueOf(i)};
		}
		return objects;
	}
	
	@DataProvider(name = "invalidMonths")
	public Object[][] getInvalidMonths(){
		return new Object[][] {
			new Object[] {"january"},
			new Object[] {"Febrary"},
			new Object[] {"Marh"},
			new Object[] {"Aril"},
			new Object[] {"Ma"},
			new Object[] {"Jne"},
			new Object[] {"uly"},
			new Object[] {"ugust"},
			new Object[] {"eptember"},
			new Object[] {"ctober"},
			new Object[] {"ovember"},
			new Object[] {"ecember"}
		};
	}

	@DataProvider(name = "months")
	public Object[][] getMonths(){
		return new Object[][] {
			new Object[] {"January"},
			new Object[] {"February"},
			new Object[] {"March"},
			new Object[] {"April"},
			new Object[] {"May"},
			new Object[] {"June"},
			new Object[] {"July"},
			new Object[] {"August"},
			new Object[] {"September"},
			new Object[] {"October"},
			new Object[] {"November"},
			new Object[] {"December"}
		};
	}
	
	@DataProvider(name = "invalidPort")
	public Object[][] getInvalidPort(){
		return new Object[][] {
			new Object[] {"Atlanta"},
			new Object[] {"Chicago"},
			new Object[] {"Bismark"}
		};
	}

	
	@DataProvider(name = "fromPort")
	public Object[][] getFromPort(){
		return new Object[][] {
			new Object[] {"Acapulco"},
			new Object[] {"Frankfurt"},
			new Object[] {"London"},
			new Object[] {"New York"},
			new Object[] {"Paris"},
			new Object[] {"Portland"},
			new Object[] {"San Francisco"},
			new Object[] {"Seattle"},
			new Object[] {"Sydney"},
			new Object[] {"Zurich"}
		};
	}
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials(){
		return new Object[][] {
					new Object[] {"mercury", "mercury"},
					new Object[] {"firstParameter", "secondParameter"},
					new Object[] {"William", "Gentree"}
		};
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
