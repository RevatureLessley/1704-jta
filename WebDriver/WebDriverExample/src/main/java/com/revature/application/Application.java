package com.revature.application;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = null;
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		// Instantiates our WebDriver as a Chrome browser instance
		driver = new ChromeDriver();
		
		// driver.get() makes a GET request to the provided URL
		driver.get("http://google.com");
		
		Thread.sleep(2000); // DONT EVER DO THIS. BAD PRACTICE. Just for demonstration purpose
		
		// ALWAYS make sure to quit() your webdrivers
		driver.quit();
	}
}
