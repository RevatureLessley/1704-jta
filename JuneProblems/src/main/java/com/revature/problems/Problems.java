package com.revature.problems;


/*
 * @author: Skaggs
 * 
 * */
public class Problems {

	public static void main(String[] args) {
	}
	
	public static int factorial(int n) {
		if ( n < 2 ) return 1; 
		
		return n * factorial(n-1);
	}
	public static boolean isPalindrome(String s) {
		return areStringsEqual(s.toLowerCase(), reverseString(s.toLowerCase()));
	}
	
	public static void fizzBuzz() {
		for (int i=1; i < 101; i++) {
			System.out.print(i);
			if (isDivisibleByThree(i)) System.out.print(" Fizz");
			if (isDivisibleByFive(i)) System.out.print(" Buzz");
			System.out.println();
			
		}
	}
	public static String modifyString(String s) {
		if (s.length() < 2) return s;
		String ns ="";
		ns = reverseString(s.substring(0, 2)) + " ";

		return ns + modifyString(s.substring(2));
	}
	
	private static boolean isDivisibleByThree(int n) {
		return n % 3 == 0;
	}
	private static boolean isDivisibleByFive(int n) {
		return n % 5 == 0;
	}
	
	private static boolean areStringsEqual(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static int recursiveFib(int n) {
		if (n < 2) return n;
		return recursiveFib(n-1) + recursiveFib(n-2); 
		
	}
	public static int iterativeFib(int n) {
		if (n < 2) return n;
		int cur =  1, prev = 1; //Learned this from the OCA!
		for (int i = 2; i < n; i++) {
			int old = cur; cur += prev; prev = old;		
		} 
		return cur;
	}
	
	public static String reverseString(String s) {
		String rs = "";
		for ( int i = s.length()-1; i >= 0; i-- ) {
			rs += s.charAt(i);
		}
		return rs;
	}
}
