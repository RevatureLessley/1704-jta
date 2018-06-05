package com.revature.implementation;

public class Fibonacci {

	public static int iterative(int count) {
		int toBeReturned = 0;
		
		if(count == 0)
			return 1;
		else if(count == 1)
			return 1;
		else {
			int[] arr = new int[count];
			arr[0] = 1; 
			arr[1] = 1;
			for(int i = 2; i < count; i++) {
				arr[i] = arr[i-2] + arr[i-1];
				toBeReturned = arr[i];
			}
			return toBeReturned;
		}
	}
	
	public static int recursive(int count) {
		if(count == 0) return 0;
		else if(count == 1) return 1;
		else return recursive(count - 1) + recursive(count - 2);
	}

}
