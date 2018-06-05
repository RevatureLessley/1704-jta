package com.revature.solutions;

public class Factorial {

	public static int factorialRecursive(int factorial) {
		if (factorial == 0) 
			return 1;
		else
			return factorial * factorialRecursive(factorial - 1);
	}
	
	public static int factorialIterative(int value) {
		int factorial = 1;
		for(int i = 1; i <= value; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
	
}
