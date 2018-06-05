package com.revature.TestNG;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import com.revature.solutions.SolutionImpl;

public class SolutionTest {
	@Test
	public void isPalindromeTestTrue(){
		assertTrue(SolutionImpl.isPalindrome("a"));
		assertTrue(SolutionImpl.isPalindrome("aa"));
		assertTrue(SolutionImpl.isPalindrome("aba"));
		assertTrue(SolutionImpl.isPalindrome("aabbaa"));
		assertTrue(SolutionImpl.isPalindrome("aabcbaa"));
	}
	
	@Test
	public void isPalindromeTestFalse() {
		assertFalse(SolutionImpl.isPalindrome("ab"));
		assertFalse(SolutionImpl.isPalindrome("abb"));
		assertFalse(SolutionImpl.isPalindrome("abcd"));
	}
	
	
	@Test
	public void reverseString() {
		assertEquals("leinaD",SolutionImpl.reverseString("Daniel"));
		assertEquals("backwards",SolutionImpl.reverseString("sdrawkcab"));
		assertEquals("drawrof",SolutionImpl.reverseString("forward"));
	}
	
	@Test
	public void iterativeFibTest() {
		assertEquals(55,SolutionImpl.iterativeFib(10));
		assertEquals(0,SolutionImpl.iterativeFib(0));
		assertEquals(1,SolutionImpl.iterativeFib(1));
		assertEquals(21,SolutionImpl.iterativeFib(8));
	}
	
	@Test
	public void recursiveFibTest() {
		assertEquals(55,SolutionImpl.recursiveFib(10));
		assertEquals(0,SolutionImpl.recursiveFib(0));
		assertEquals(1,SolutionImpl.recursiveFib(1));
		assertEquals(21,SolutionImpl.recursiveFib(8));
	}
	
	@Test
	public void factorialTest() {
		assertEquals(120,SolutionImpl.factorial(5));
		assertEquals(1,SolutionImpl.factorial(0));
		assertEquals(1,SolutionImpl.factorial(1));
		assertEquals(40320,SolutionImpl.factorial(8));
	}
	@Test
	public void modifyStringTest() {
		assertEquals("iW ll ai m", SolutionImpl.modString("William"));
		assertEquals("aD in le", SolutionImpl.modString("Daniel"));
		assertEquals("ps a  ec", SolutionImpl.modString("sp ace"));
	}
}
