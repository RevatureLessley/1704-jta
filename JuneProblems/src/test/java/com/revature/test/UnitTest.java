package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.problems.Problems;

public class UnitTest {

	@Test
	public void testIsPalindrome() {
		assertTrue(Problems.isPalindrome("Racecar"));
		assertFalse(Problems.isPalindrome("cameron"));
	}
	
	@Test
	public void testReverseString() {
		assertEquals(Problems.reverseString("stuff"), "ffuts");
		assertNotEquals(Problems.reverseString("stuff"), "stuff");
	}
	@Test
	public void testRecursiveFib() {
		assertEquals(Problems.recursiveFib(7), 13);
		assertEquals(Problems.recursiveFib(8), 21);
	}
	@Test
	public void testIterativeFib() {
		assertEquals(Problems.iterativeFib(7), 13);
		assertEquals(Problems.iterativeFib(8), 21);
	}
	@Test
	public void testFactorial() {
		assertEquals(Problems.factorial(4), 24);
	}
	
	@Test
	public void testModifyString() {
		assertEquals(Problems.modifyString("William"), "iW ll ai m");
	}
}
