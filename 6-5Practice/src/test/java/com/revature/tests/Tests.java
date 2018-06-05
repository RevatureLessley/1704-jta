package com.revature.tests;

import com.revature.Exec.Methods;
import com.revature.Exec.NonPositiveValueException;
import com.revature.Exec.ResultOutOfRangeException;

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
	public void iter() throws Exception {
		assertEquals(m.iterativeFib(10), 55);
	}
	
	@Test(expected=ResultOutOfRangeException.class)
	public void iterLarge() throws Exception{
		m.iterativeFib(47);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void iterZero() throws Exception {
		m.iterativeFib(0);
	}
	
	@Test
	public void recurse() throws Exception{
		assertEquals(m.recursiveFib(10), 55);
	}
	
	@Test(expected=ResultOutOfRangeException.class)
	public void recurseLarge() throws Exception{
		m.recursiveFib(47);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void recurseZero() throws Exception{
		m.recursiveFib(0);
	}
	@Test
	public void fact() throws Exception{
		assertEquals(m.factorial(10), 3628800);
	}
	
	@Test(expected=NonPositiveValueException.class)
	public void factZero() throws Exception{
		m.factorial(0);
	}
	
	@Test public void modifyEven() throws NonPositiveValueException{
		assertEquals(m.modifyString("Hello, World"), "eH ll ,o W  ro dl");
	}
	
	@Test public void modifyOdd() throws NonPositiveValueException{
		assertEquals(m.modifyString("William"), "iW ll ai m");
	}

}
