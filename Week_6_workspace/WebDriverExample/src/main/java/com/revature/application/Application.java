package com.revature.application;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

	public static void main(String[] args) {
		WebDriver driver = null;
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		
		try {
			// Instantiates our WebDriver as a Chrome browser instance
			driver = new ChromeDriver();
			
			// driver.get() makes a GET request to the provided URL
			
			driver.get("http://google.com");
			driver.findElement(By.name("q")).sendKeys("cat");
			
			driver.findElement(By.name("btnK")).submit();
			driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).click();	
			
			
//			driver.get("http://dev-caliber.revature.tech/caliber/#/trainer/home");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//			driver.findElement(By.linkText("user guide")).click();
////			driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div[1]/p/a")).click();
////			//a[contains(.,'user guide')]
////			/html/body/div/ui-view/ui-view/div[1]/div[1]/p/a
			
			// Thread.sleep(2000); BAD PRACTICE
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// ALWAYS quit() YOUR WEBDRIVERS
			driver.quit();

		}
		
	}
}
