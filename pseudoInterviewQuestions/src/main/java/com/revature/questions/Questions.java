package com.revature.questions;

import java.io.IOException;
import java.io.PrintWriter;

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

	public static void fizzBuzzOneLinerMaker() {
		boolean flag = false;
		for (int i = 1; i <= 100; i++) {

			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.print("System.out.printf(\"fizzbuzz\\n\") == null |");
					continue;
				}
				System.out.print("System.out.printf(\"fizz\\n\") == null |");
				continue;
			}
			if (i % 5 == 0) {
				System.out.print("System.out.printf(\"buzz\\n\") == null |");
				continue;
			}
			System.out.print("System.out.printf(\"" + i + "\\n\") == null |");
		}
	}

	public static void fizzBuzzOneLiner() {
		boolean b = System.out.printf("1\n") == null |System.out.printf("2\n") == null |System.out.printf("fizz\n") == null |System.out.printf("4\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("7\n") == null |System.out.printf("8\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("11\n") == null |System.out.printf("fizz\n") == null |System.out.printf("13\n") == null |System.out.printf("14\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("16\n") == null |System.out.printf("17\n") == null |System.out.printf("fizz\n") == null |System.out.printf("19\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("22\n") == null |System.out.printf("23\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("26\n") == null |System.out.printf("fizz\n") == null |System.out.printf("28\n") == null |System.out.printf("29\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("31\n") == null |System.out.printf("32\n") == null |System.out.printf("fizz\n") == null |System.out.printf("34\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("37\n") == null |System.out.printf("38\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("41\n") == null |System.out.printf("fizz\n") == null |System.out.printf("43\n") == null |System.out.printf("44\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("46\n") == null |System.out.printf("47\n") == null |System.out.printf("fizz\n") == null |System.out.printf("49\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("52\n") == null |System.out.printf("53\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("56\n") == null |System.out.printf("fizz\n") == null |System.out.printf("58\n") == null |System.out.printf("59\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("61\n") == null |System.out.printf("62\n") == null |System.out.printf("fizz\n") == null |System.out.printf("64\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("67\n") == null |System.out.printf("68\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("71\n") == null |System.out.printf("fizz\n") == null |System.out.printf("73\n") == null |System.out.printf("74\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("76\n") == null |System.out.printf("77\n") == null |System.out.printf("fizz\n") == null |System.out.printf("79\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("82\n") == null |System.out.printf("83\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null |System.out.printf("86\n") == null |System.out.printf("fizz\n") == null |System.out.printf("88\n") == null |System.out.printf("89\n") == null |System.out.printf("fizzbuzz\n") == null |System.out.printf("91\n") == null |System.out.printf("92\n") == null |System.out.printf("fizz\n") == null |System.out.printf("94\n") == null |System.out.printf("buzz\n") == null |System.out.printf("fizz\n") == null |System.out.printf("97\n") == null |System.out.printf("98\n") == null |System.out.printf("fizz\n") == null |System.out.printf("buzz\n") == null;
	}

	public static void main(String[] args) throws IOException {
		fizzBuzz();
		System.out.println("I also made a terrible one liner for fizz buzz just because.");
		fizzBuzzOneLiner();
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