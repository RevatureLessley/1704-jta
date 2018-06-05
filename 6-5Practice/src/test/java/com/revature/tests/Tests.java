package com.revature.tests;

import com.revature.Exec.Methods;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	Methods m=new Methods();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void palindromeTrue() {
		assertTrue(m.isPalindrome("wasitaratisaw"));
	}
	
	@Test
	public void palindromeFalse() {
		assertFalse(m.isPalindrome("hello"));
	}
	
	@Test
	public void iter() {
		assertEquals(m.iterativeFib(10), 55);
	}
	
	@Test
	public void recurse() {
		assertEquals(m.recursiveFib(10), 55);
	}
	
	@Test public void fact() {
		assertEquals(m.factorial(10), 3628800);
	}
	
	@Test public void modifyEven() {
		assertEquals(m.modifyString("Hello, World"), "eH ll ,o W  ro dl");
	}
	
	@Test public void modifyOdd() {
		assertEquals(m.modifyString("William"), "iW ll ai m");
	}

}
