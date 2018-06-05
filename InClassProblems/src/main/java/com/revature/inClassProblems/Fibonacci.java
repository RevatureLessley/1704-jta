package com.revature.inClassProblems;

public class Fibonacci {

	public static int iterativeFib(int n) {
		
		int sum = 0;
		int newFib = 0;
		int oldFib = 0;
		for (int i = 0; i < n; i++) {
			oldFib = newFib;
			newFib = sum;
			sum = oldFib + newFib;
			if(sum == 0) sum++;
		}
		
		return sum;
	}
	
	public static int recursiveFib(int n) {
		
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}	
		return recursiveFib(n - 1) + recursiveFib(n - 2);
	}
}
