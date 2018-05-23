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
