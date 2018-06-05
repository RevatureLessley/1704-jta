package com.revature.unitTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.solutions.Palindrome;



public class PalindromeTests {

	@Test
	public void isPalendromeTestPass() {
		assertTrue(Palindrome.isPalindrome("asdfgfdsa"));
	}

	
}
