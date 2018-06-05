package com.revature.inClassProblems;

public class Swap {

	private static String temp = "";
	
	public static void emptryString() {
		temp = "";
	}
	
	public static String modifyString(String string) {

		for (int i = 0; i < string.length(); i = i + 2) {
			if (i + 1 < string.length()) temp += "" + string.charAt(i + 1) + string.charAt(i) + " ";
			else temp += "" + string.charAt(i);
		}
		return temp;
	}
}
