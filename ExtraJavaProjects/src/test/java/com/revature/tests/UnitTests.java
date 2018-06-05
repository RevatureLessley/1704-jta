package com.revature.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.implementation.Factorial;
import com.revature.implementation.Fibonacci;
import com.revature.implementation.Palindrome;
import com.revature.implementation.Reverse;
import com.revature.implementation.Switch;

public class UnitTests {
	

	
	/**
	 * The test of the class Reverse is done using a StringBuilder, which surely reverses a string 
	 */
	@Test
	public void reverseStringTest() {
		// Parameter to test 
		String toBeReversed = "neat";
		
		StringBuilder builder = new StringBuilder(toBeReversed);
		String reversed = Reverse.reverseString(toBeReversed);
		assertTrue(String.valueOf(builder.reverse()).equals(reversed));
	}

	
	/**
	 * The palindrome test uses the Reverse class and tests common palindromes
	 * 
	 * First, given a real palindrome, should return true
	 * Next, given a false palindrome, should return false
	 */
	@Test
	public void palindromeTest() {
		// Actual palindrome 
		String palindrome = "racecar";
		
		assertTrue(Palindrome.isPalindrome(palindrome));
	}
	@Test
	public void isNotPalindromeTest() {
		// False palindrome 
		String notPalindrome = "neat";
		
		assertFalse(Palindrome.isPalindrome(notPalindrome));
	}
	

	
	/**
	 * Checks the Fibonacci iterative method 
	 * 
	 * Given you want an int n-th number of the Fibonacci sequence, then the result is int num 
	 * If num is a part of the Fibonacci sequence, then the square * 5 + 4 or - 4 should be a square itself 
	 * ~~ M A T H ~~
	 * 
	 * fibFalseMethodTest - emulates a false Fibonacci sequence method output
	 * fibTrueTest - tests the above tests, given a known Fibonacci sequence num
	 * 
	 */
	
	// Checks to see if the int n is a square
	// This is needed to check the Fibonacci sequence
	public static boolean perfectSquareCheck(int n) {
		int square = (int) Math.sqrt(n);
		return (square*square == n);
	}
	
	@Test
	public void fibIterTest() {
		// Find the sequence num up to this
		int n = 5;
		
		int num = Fibonacci.iterative(n);
		assertTrue(perfectSquareCheck(5*num*num + 4) || perfectSquareCheck(5*num*num - 4));
	}
	@Test
	public void fibRecTest() {
		// Find the sequence num up to this
		int n = 5;
		
		int num = Fibonacci.recursive(n);
		assertTrue(perfectSquareCheck(5*num*num + 4) || perfectSquareCheck(5*num*num - 4));
	}
	@Test
	public void fibFalseMethodTest() {
		int num = 100;
		assertFalse(perfectSquareCheck(5*num*num + 4) || perfectSquareCheck(5*num*num - 4));
	}
	@Test
	public void fibTrueTest() {
		int num = 6765;
		assertTrue(perfectSquareCheck(5*num*num + 4) || perfectSquareCheck(5*num*num - 4));
	}
	
	
	
	/**
	 * Ensures the correct output from the factorial method
	 * 
	 * First, given some int testInt, calculate the factorial (saved as test)
	 * Then, loop through the int test, and ensure it can be divided by an incrementing int i in a for loop 
	 * Finally, ensure the final int test after being divided int i times that it is the same as the original given int testInt 
	 * 
	 * The first test factorialTrueTest checks to see if the method works as intended
	 * The second test factorialFalseMethodOutputTest ensures the testing method factorialTrueTest works, assuming a false method output
	 * The final test factorialFalseGivenTest ensures the testing method factorialTrueTest works and produces the correct factorial of testInt
	 */
	@Test
	public void factorialTrueTest() {
		boolean isFactorial = false;
		int testInt = 10;
		int test = Factorial.factorial(testInt);
		for(int i = 1; i < test; i++) {
			if(test%i == 0) {
				isFactorial = true;
				test = test/i;
			}
			else {
				isFactorial = false;
				break;
			}
		}
		assertTrue(isFactorial);
		assertTrue(test == testInt);
	}
	@Test
	public void factorialFalseMethodOutputTest() {
		boolean isFactorial = false;
		int test = 1000;
		for(int i = 1; i < test; i++) {
			if(test%i == 0) {
				isFactorial = true;
				test = test/i;
			}
			else {
				isFactorial = false;
				break;
			}
		}
		assertFalse(isFactorial);
	}
	@Test
	public void factorialFalseGivenTest() {
		boolean isFactorial = false;
		int testInt = 10;
		int test = Factorial.factorial(testInt);	
		test = 120;
		for(int i = 1; i < test; i++) {
			if(test%i == 0) {
				isFactorial = true;
				test = test/i;
			}
			else {
				isFactorial = false;
				break;
			}
		}
		assertTrue(isFactorial);
		assertFalse(test == testInt);
	}
	
	/**
	 * First, asserts there must be a space in the switched string (after calling the method to modify the string) 
	 * Next, asserts the first and second letters are switched, using two separate assertions 
	 * Finally, checks to see if the remaining string is still the same 
	 */
	@Test
	public void spaceTest() {
		String toBeSwitched = "William";
		String switched = Switch.modifyString(toBeSwitched);
		
		assertTrue(switched.substring(2, 3).equals(" "));
		assertTrue(switched.substring(0, 1).equals(toBeSwitched.substring(1, 2)));
		assertTrue(switched.substring(1, 2).equals(toBeSwitched.substring(0, 1)));
		assertTrue(switched.substring(4).equals(toBeSwitched.substring(3)));
	}
	
	

}
