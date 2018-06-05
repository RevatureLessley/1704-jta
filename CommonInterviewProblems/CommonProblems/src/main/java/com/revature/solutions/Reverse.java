package com.revature.solutions;

public class Reverse {

	public static String reverseString(String string) {
		StringBuilder reverse = new StringBuilder();		
		int index = 0;
		
		try {
			while (true) {
				string.charAt(index);
				index++;
			}
		} catch (IndexOutOfBoundsException e) {
			for (int i = index -1; i >= 0; i--) {
				reverse.append(string.charAt(i));
			}
		}
		return reverse.toString();
	}
}
