package com.revature.inClassProblems;

public class Factorial {

	public static int recursiveFactorial(int i) {
		if (i == 1) {
			return 1;
		}
		return i * (recursiveFactorial(--i));
	}
}
