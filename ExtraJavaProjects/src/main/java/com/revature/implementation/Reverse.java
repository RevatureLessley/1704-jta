package com.revature.implementation;

public class Reverse {

	public static String reverseString(String toBeReversed) {
		int size = 0;

		try {
			while(true) {
				toBeReversed.charAt(size);
				size++;
			}
		} catch(IndexOutOfBoundsException iobe) {
			iobe.getMessage();
		}
		
		char[] at = new char[size];
		
		for(int i = 0; i < size; i++) {
			at[i] = toBeReversed.charAt(size - i - 1);
		}
		
		String reversed = new String (at);
		
		return reversed;
	}

}
