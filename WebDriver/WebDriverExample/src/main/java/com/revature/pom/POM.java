package com.revature.pom;

import org.openqa.selenium.WebDriver;

public abstract class POM {

	protected WebDriver driver;
	public POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return this.driver.getTitle();
	}
}
