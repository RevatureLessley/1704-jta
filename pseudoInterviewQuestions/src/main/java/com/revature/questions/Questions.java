package com.revature.questions;

public class Questions {

	public static boolean isPalindrome(String s) {
		return s.length() <= 1 || (s.charAt(0) == s.charAt(s.length() - 1)) && isPalindrome(s.substring(1, s.length() - 1));
	}

	public static String reverseStringHelper(String s, int index) {
		try {
			char c = s.charAt(index);
			return reverseStringHelper(s, index + 1) + c;
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}

	public static String reverseString(String s) {
		return reverseStringHelper(s, 0);
	}

	//Gets the nth (zero indexed) item of the fibonacci sequence,
	// using the variant of the fibonacci sequence which starts with 0
	public static int iterativeFib(int count) {
		int curr = 0;
		int prev = 0;
		int tmp = 0;
		for (int i = 0; i < count; i++) {
			if (curr == 0) {
				curr = 1;
				continue;
			}
			tmp = curr;
			curr = curr + prev;
			prev = tmp;
		}
		return curr;
	}

	public static int recursiveFib(int count) {
		return count == 0 ? 0 : count == 1 ? 1 : recursiveFib(count - 1) + recursiveFib(count - 2);
	}

	public static void fizzBuzz() {
		boolean flag = false;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.print("fizz");
				flag = true;
			}
			if (i % 5 == 0) {
				System.out.print("buzz");
				flag = true;
			}
			if (!flag) {
				System.out.print(i);
			}
			flag = false;
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		fizzBuzz();
	}

	// Note, will only work for factorials in which the answers are less than the max value of an integer.
	public static int factorial(int num) {
		if (num < 0) {
			throw new ArithmeticException();
		}
		if (num > 12) {
			throw new UnsupportedOperationException();
		}
		return num == 0 || num == 1 ? 1 : num * factorial(num - 1);
	}

	public static String modifyString(String s) {
		return s.length() > 2 ? Character.toString(s.charAt(1)) + Character.toString(s.charAt(0)) + " " + modifyString(s.substring(2)) : s.length() > 1 ? Character.toString(s.charAt(1)) + Character.toString(s.charAt(0)) + " " : s;
	}
}