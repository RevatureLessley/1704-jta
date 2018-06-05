package com.revature.application;

import com.revature.implementation.Factorial;
import com.revature.implementation.Fibonacci;
import com.revature.implementation.Fizzy;
import com.revature.implementation.Palindrome;
import com.revature.implementation.Reverse;
import com.revature.implementation.Switch;

public class Application {

	public static void main(String[] args) {
		String reversethis = "neat";
		
		System.out.println(reversethis + " is reversed here: " + Reverse.reverseString(reversethis));
		System.out.println(reversethis + " is a palindrome: " + Palindrome.isPalindrome(reversethis));
		
		int count = 20;
		
		System.out.println("\n\nThe " + count + " number of Fibonacci is " + Fibonacci.iterative(count));
		System.out.println("The " + count + " number of Fibonacci is " + Fibonacci.recursive(count));
		
		Fizzy.fizzBuzz();
		
		int calc = 5;
		System.out.println("\n\nThe factorial of " + calc + " is " + Factorial.factorial(calc));
		
		String toBeModified = "neat";
		System.out.println("\n\nThe modified string is " + Switch.modifyString(toBeModified));
	
		
	}

}
