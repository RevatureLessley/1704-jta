package com.revature.implementation;

public class Factorial {

	public static int factorial(int n) {
		int calc = 1;
		for(int i = 1; i < (n+1); i++) calc = calc * i;
		return calc;
	}

}
