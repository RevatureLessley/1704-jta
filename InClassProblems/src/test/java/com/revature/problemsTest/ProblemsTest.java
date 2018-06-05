package com.revature.problemsTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.inClassProblems.Factorial;
import com.revature.inClassProblems.Fibonacci;
import com.revature.inClassProblems.Palindrome;
import com.revature.inClassProblems.Reverse;
import com.revature.inClassProblems.Swap;

public class ProblemsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void testPalindrome() {
		assertTrue(Palindrome.isPalindrome("asantalivedasadevilatnasa"));
		assertFalse(Palindrome.isPalindrome("penguins"));
	}
	
	@Test
	public void testReverseString() {
		assertEquals(Reverse.reverseString("penguins"), "sniugnep");
		assertNotEquals(Reverse.reverseString("Ponyta"), "sniugnep");
		Reverse.emptyString();
		assertEquals(Reverse.THECOOLWAY("penguins"), "sniugnep");
		assertNotEquals(Reverse.THECOOLWAY("Rattata"), "sniugnep");
		Reverse.emptyString();
		assertEquals(Reverse.THECOOLESTWAY("penguins"), "sniugnep");
		assertNotEquals(Reverse.THECOOLESTWAY("Polliwag"), "sniugnep");
	}
	
	@Test
	public void testItFib() {
		assertTrue(Fibonacci.iterativeFib(6) == 8);
		assertFalse(Fibonacci.iterativeFib(7) == 8);
	}
	
	@Test
	public void testReFib() {
		assertTrue(Fibonacci.iterativeFib(6) == 8);
		assertFalse(Fibonacci.iterativeFib(7) == 8);
	}
	
	@Test
	public void testFizzBuzz() {
		
	}
	
	@Test
	public void testFactorial() {
		assertTrue(Factorial.recursiveFactorial(5) == 120);
		assertFalse(Factorial.recursiveFactorial(7) == 120);
	}
	
	@Test
	public void testSwap() {
		assertEquals(Swap.modifyString("Penguins"), "eP gn iu sn ");
		Swap.emptryString();
		assertEquals(Swap.modifyString("Penguin"), "eP gn iu n");
	}
}
