package com.revature.solutions;

public class Fibonacci {

	public static int iterativeFib(int nthValue) {
		int current = 1;
		int previous = 1;
		int tempCurrent;
		if (nthValue == 1 | nthValue == 2)
			return 1;
		else {
			for (int i = 3; i <= nthValue; i++) {
				tempCurrent = current;
				current += previous;
				previous = tempCurrent;
			}
			return current;
		}
	}

	public static int recursiveFib(int nthValue) {
		if (nthValue <= 1 | nthValue == 2) 
			return 1;
		else 
			return recursiveFib(nthValue - 1) + recursiveFib(nthValue - 2);
		
	}

}
