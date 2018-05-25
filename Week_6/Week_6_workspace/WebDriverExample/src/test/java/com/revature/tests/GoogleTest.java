package com.revature.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.revature.driver.DriverFactory;

public class GoogleTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void beforeSuite() {
		driver = DriverFactory.getDriver("chrome");
		
		// We can configure our driver's implicit wait as soon as it is instantiated
		// For any element, wait 3 seconds before determining a fail
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// We can configure our driver's explicit wait as soon as it is instantiated 
		// For a specific action, wait 4 seconds before determining a fail
		wait = new WebDriverWait(driver, 4);
	}
	
	@Test(priority=1)
	public void navigateToGoogle() {
		driver.get("http://google.com");
	}
	
	@Test(priority=2)
	public void validateNavigateToGoogle() {
		assertEquals("Google", driver.getTitle());
	}
	
	@Test(priority=3)
	public void searchCats() {
		driver.findElement(By.id("lst-ib")).sendKeys("cats");
	}
	
	@Test(priority=4)
	public void submitCatSearch() {
//		driver.findElement(By.name("btnK")).submit();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).submit();
	}
	
	@Test(priority=5)
	public void validateCatSearch() {
		assertEquals("cats - Google Search", driver.getTitle());
	}

	@AfterSuite
	public void afterSuite() {
		// ALWAYS CALL driver.quit() OR driver.close()
		// If you do not, there will be a myriad of hidden chrome webdriver instances on your computer
		// Unless you like working with slow computers...
		driver.quit();
	}

}
