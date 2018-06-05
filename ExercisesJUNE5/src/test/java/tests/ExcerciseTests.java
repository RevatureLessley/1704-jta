package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exercises.CharacterSwap;
import exercises.Factorial;
import exercises.Fibonacci;
import exercises.Palindrome;
import exercises.ReverseString;

public class ExcerciseTests {

	
	@Test
	public void PalindromeTest() {
		assertTrue(Palindrome.isPalindrome("racecar"));
	}
	@Test
	public void falsePalindrome() {
		assertFalse(Palindrome.isPalindrome("andy"));
	}
	
	@Test
	public void reverseStringTest() {
		assertTrue("ippississim".equals(ReverseString.reverseString("mississippi")));
		assertTrue("ydna".equals(ReverseString.reverseString("andy")));
	}
	
	@Test
	public void iterativeFibonacci() {
		assertEquals(21, Fibonacci.iterative(8));
	}
	
	@Test
	public void recursiveFibonacci() {
		assertEquals(21,Fibonacci.recursive(8));
	}
	
	@Test
	public void Factor() {
		assertEquals(120,Factorial.factorial(5));
		assertEquals(720,Factorial.factorial(6));
	}
	
	@Test
	public void modify() {
		assertTrue("iw ll ai m".equals(CharacterSwap.modifyString("william")));
		assertTrue("na yd".equals(CharacterSwap.modifyString("andy")));
	}

}
