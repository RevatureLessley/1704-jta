package com.revature.inClassProblems;

public class Palindrome {

	public static boolean isPalindrome(String string) {

		String temp;
		int length = string.length();
		temp = string.substring(0, length / 2 + 1);
		for (int i = 0; i < length / 2; i++) {
			if (temp.charAt(i) != (string.charAt((char)(length - 1) - i))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.print(isPalindrome("timt"));
	}
}
