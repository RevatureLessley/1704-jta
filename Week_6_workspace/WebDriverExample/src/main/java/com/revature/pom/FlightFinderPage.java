package com.revature.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends POM {

	public FlightFinderPage(WebDriver driver) {
		super(driver);
	}

	public void roundTripRadioBtn() {
		driver.findElement(By.xpath(
				"html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]"))
				.click();
		// driver.findElement(By.xpath("//*input[contains('value',
		// 'roundtrip')]")).click();
	}

	public void onewayTripRadioBtn() {
		driver.findElement(By.xpath(
				"html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"))
				.click();
		// driver.findElement(By.xpath("//*input[contains('value',
		// 'oneway')]")).click();
	}

	public void numberOfPassengersDropdown(int num) {
		if (num < 1 || num > 4) {
			throw new IllegalArgumentException("Number of passengers must be 1, 2, 3, or 4");
		}
		Select passengers = new Select(driver.findElement(By.name("passCount")));
		passengers.selectByValue(String.valueOf(num));
	}

	public void departingFromDropdown(String location) {
		List<WebElement> listOfLocations = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		Select locations = new Select(driver.findElement(By.name("fromPort")));
		for (WebElement we : listOfLocations) {
			if (we.getText().equals(location)){
				locations.selectByValue(location);
				return;
			}
		}
		throw new IllegalArgumentException(location + " is not a valid location");
//		
//		if (listOfLocations.contains(location)) {
//			locations.selectByValue(location);
//		} else {
//			throw new IllegalArgumentException(location + " is not a valid location");
//		}
	}
	
	public void flightFinderDropdown(String input, String locator) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//select[@name='" + locator + "']/option"));
		Select select = new Select(driver.findElement(By.name(locator)));
		for (WebElement we : listOfElements) {
			if (we.getText().equals(input)) {
				select.selectByVisibleText(input);
				return;
			}
		}
		throw new IllegalArgumentException(input + " is not a valid input");
	}

}





