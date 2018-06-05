package com.revature.solutions;

public class Palindrome {

	public static boolean isPalindrome(String string) {
		for(int i = 0, j = string.length() - 1;
				i <= j;
				i++, j--) {
			if (string.charAt(i) == string.charAt(j)) 
				continue;
			else 
				return false;
		}
		
		return true;
	}
}
