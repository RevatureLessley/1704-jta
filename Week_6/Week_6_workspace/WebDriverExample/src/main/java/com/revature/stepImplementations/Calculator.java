package com.revature.stepImplementations;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiplication(int x, int y) {
		return x * y;
	}

	public int divide(int a, int b) {
		if (b==0) {
			throw new IllegalArgumentException("Denominator cannot equal 0");
		}
		return a / b;
	} 
}
