package com.revature.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelloWorldTest {
	
	@Test(groups="hello")
	public void firstTestNGTest() {
		System.out.println("     Hello, World!");
	}
	
	@Test(groups="goodbye")
	public void secondTestNGTest() {
		System.out.println("     Goodbye, World :(");
	}

	@BeforeGroups(groups= {"hello", "goodbye"})
	public void beforeGroups() {
		System.out.println("   BEFORE GROUPS");
	}

	@AfterGroups(groups= {"hello", "goodbye"})
	public void afterGroups() {
		System.out.println("   AFTER GROUPS");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("    BEFORE METHOD");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("    AFTER METHOD");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("  BEFORE CLASS");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("  AFTER CLASS");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" BEFORE TEST");
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" AFTER TEST");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BEFORE SUITE");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AFTER SUITE");
	}

}
