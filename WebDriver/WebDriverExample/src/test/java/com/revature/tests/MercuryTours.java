package com.revature.tests;

import static org.testng.Assert.assertEquals;

import java.time.Month;
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
		
		// Implicit Wait 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Explicit Wait
		wait = new WebDriverWait(driver, 1);
	}
	
	@Test(priority=1)
	public void navigateToMercuryTours() {
		home = new HomePage(driver);
	}
	
	@Test(priority=2)
	public void validateSuccessfulNavigationToMercuryTours() {
		assertEquals("Welcome: Mercury Tours", home.getPageTitle());
	}
	
	@Test(priority=3)
	public void validateUsernameInputElement() {
		assertEquals("text", home.usernameField().getAttribute("type"));
	}
	
	@Test(priority=4)
	public void validatePasswordInputElement() {
		assertEquals("password", home.passwordField().getAttribute("type"));
	}
	
	@Test(priority=5, enabled=true)
	@Parameters("username")
	public void enterUsername(String username) {
		home.usernameField().sendKeys(username);
	}
	
	@Test(priority=6, enabled=true)
	@Parameters("password")
	public void enterPassword(String password) {
		home.passwordField().sendKeys(password);
	}
	
	@Test(priority=7, dataProvider="credentials", enabled=false)
	public void enterCredentialsIntoUsernameAndPassword(String username, String password) {
		System.out.println(username + " => " + password);
	}
	
	@Test(priority=8)
	public void clickSignInButton() {
		home.signInButton().click();
	}
	
	@Test(priority=9)
	public void validateFlightFinderPage() {
		flight = new FlightFinderPage(driver);
		assertEquals("Find a Flight: Mercury Tours:", flight.getPageTitle());
	}
	
	@Test(priority=10)
	public void clickOneWayTrip() {
		flight.oneWayTripRadioButton();
	}
	
	@Test(priority=11)
	public void clickRoundTrip() {
		flight.roundTripRadioButton();
	}
	
	@Test(priority=12)
	public void selectFourPassengers() {
		flight.numberOfPassengersDropdown(4);
	}
	
	@Test(priority=13)
	public void selectThreePassengers() {
		flight.numberOfPassengersDropdown(3);
	}
	
	@Test(priority=14)
	public void selectTwoPassengers() {
		flight.numberOfPassengersDropdown(2);
	}
	
	@Test(priority=15)
	public void selectOnePassengers() {
		flight.numberOfPassengersDropdown(1);
	}
	
	@Test(priority=16, expectedExceptions = {IllegalArgumentException.class})
	public void selectBelowPossiblePassengers() {
		flight.numberOfPassengersDropdown(0);
	}
	
	@Test(priority=17, expectedExceptions = {IllegalArgumentException.class})
	public void selectAbovePossiblePassengers() {
		flight.numberOfPassengersDropdown(5);
	}
	
	@Test(priority=18, dataProvider="fromPort")
	public void selectLocationToDepartFrom(String location) {
		flight.flightFinderDropdown(location, "fromPort");
	}
	
	@Test(priority=19, dataProvider="invalidPort", expectedExceptions= {IllegalArgumentException.class})
	public void selectInvalidDepartFrom(String location) {
		flight.flightFinderDropdown(location, "fromPort");
	}
	
	@Test(priority=20, dataProvider="months")
	public void selectDepartureMonth(String month) {
		flight.flightFinderDropdown(month, "fromMonth");
	}
	
	@Test(priority=21, dataProvider="invalidMonths", expectedExceptions= {IllegalArgumentException.class})
	public void selectInvalidDepartureMonths(String month) {
		flight.flightFinderDropdown(month, "fromMonth");
	}
	
	@Test(priority=22, dataProvider="days")
	public void selectDepartureDay(String month) {
		flight.flightFinderDropdown(month, "fromDay");
	}
	
	@Test(priority=23, dataProvider="fromPort")
	public void selectArrivalPort(String port) {
		flight.flightFinderDropdown(port, "toPort");
	}
	
	@Test(priority=24, dataProvider="months")
	public void selectArrivalMonth(String month) {
		flight.flightFinderDropdown(month, "toMonth");
	}
	
	@Test(priority=25, dataProvider="days")
	public void selectArrivalDay(String day) {
		flight.flightFinderDropdown(day, "toDay");
	}
	
	
	
	
	
	@DataProvider(name="days")
	public Object[][] getDays() {
		Object[][] objects = new Object[31][];
		for (int i = 1; i <= 31; i++) {
			objects[i-1] = new Object[] { String.valueOf(i) };
		}
		return objects;
	}
	
	
	@DataProvider(name="months")
	public Object[][] getMonths() {
		return new Object[][] {
			new Object[] { "January" },
			new Object[] { "February" },
			new Object[] { "March" },
			new Object[] { "April" },
			new Object[] { "May" },
			new Object[] { "June" },
			new Object[] { "July" },
			new Object[] { "August" },
			new Object[] { "September" },
			new Object[] { "October" },
			new Object[] { "November" },
			new Object[] { "December" }
		};
	}
	
	@DataProvider(name="invalidMonths")
	public Object[][] getInvalidMonths() {
		return new Object[][] {
			new Object[] { "january" },
			new Object[] { "Februar" },
			new Object[] { "Mrch" },
			new Object[] { "Aril" },
			new Object[] { "M@y" },
			new Object[] { "june" },
			new Object[] { "uly" }
		};
	}
	
	
	@DataProvider(name="invalidPort")
	public Object[][] getInvalidPorts() {
		return new Object[][] {
			new Object[] { "Atlanta" },
			new Object[] { "Greenville" },
			new Object[] { "Bismarck" }
		};
	}
	
	
	@DataProvider(name="fromPort")
	public Object[][] getFromPortLocations() {
		return new Object[][] {
			new Object[] { "Acapulco" },
			new Object[] { "Frankfurt" },
			new Object[] { "London" },
			new Object[] { "New York" },
			new Object[] { "Paris" },
			new Object[] { "Portland" },
			new Object[] { "San Francisco" },
			new Object[] { "Seattle" },
			new Object[] { "Sydney" },
			new Object[] { "Zurich"}
		};
	}
	
	
	@DataProvider(name="credentials")
	public Object[][] getCredentials() {
		return new Object[][] {
				new Object[] {"mercury", "mercury"}, 
				new Object[] {"firstParamter", "secondParameter"},
				new Object[] {"William", "Gentree"}
		};
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
