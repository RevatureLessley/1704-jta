package com.revature.implementation;

public class Palindrome {

	public static boolean isPalindrome(String palindrome) {		
		if(Reverse.reverseString(palindrome).equals(palindrome))
			return true;
		else
			return false;
		
	}

}
