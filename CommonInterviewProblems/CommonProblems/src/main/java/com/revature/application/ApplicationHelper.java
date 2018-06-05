package com.revature.application;

import com.revature.solutions.Factorial;
import com.revature.solutions.Fibonacci;
import com.revature.solutions.FizzBuzz;
import com.revature.solutions.Palindrome;
import com.revature.solutions.Reverse;
import com.revature.solutions.SwapCharacters;

public class ApplicationHelper {
	
	static int factorialIterative = 5;
	static int factorialRecursive = 7;
	static int iterativeFib = 24;
	static int recursiveFib = 13;
	static String isPalendromePositive = "asdfghjklkjhgfdsa";
	static String isPalendromeNegative = "notAPalendrome";
	static String reverseString = "Reverse This String";
	static String modifyString = "Modify This String";

	public static void runApp() {
		
		Factorial.factorialIterative(factorialIterative);
		
		Factorial.factorialRecursive(factorialRecursive);
		
		Fibonacci.iterativeFib(iterativeFib);
		
		Fibonacci.recursiveFib(recursiveFib);
		
		FizzBuzz.fizzBuzz();
		
		Palindrome.isPalindrome(isPalendromePositive);

		Palindrome.isPalindrome(isPalendromeNegative);

		Reverse.reverseString(reverseString);
		
		SwapCharacters.modifyString(modifyString);
	}
}
