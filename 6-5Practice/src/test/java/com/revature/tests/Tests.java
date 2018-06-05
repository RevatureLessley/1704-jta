package com.revature.tests;

import com.revature.Exec.Methods;
import com.revature.Exec.NonPositiveValueException;

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
	public void iter() throws NonPositiveValueException {
		assertEquals(m.iterativeFib(10), 55);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void iterZero() throws NonPositiveValueException {
		m.iterativeFib(0);
	}
	
	@Test
	public void recurse() throws NonPositiveValueException{
		assertEquals(m.recursiveFib(10), 55);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void recurseZero() throws NonPositiveValueException{
		m.recursiveFib(0);
	}
	@Test
	public void fact() throws NonPositiveValueException{
		assertEquals(m.factorial(10), 3628800);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void factZero() throws NonPositiveValueException{
		m.factorial(0);
	}
	
	@Test public void modifyEven() throws NonPositiveValueException{
		assertEquals(m.modifyString("Hello, World"), "eH ll ,o W  ro dl");
	}
	
	@Test public void modifyOdd() throws NonPositiveValueException{
		assertEquals(m.modifyString("William"), "iW ll ai m");
	}

}
