package com.revature.inClassProblems;

public class Reverse {

	private static String temp = "";
	private static int commitment = 10000;
	private static int runCounter = 0;
	private static int possibleLength = 0;
	
	public static void emptyString() {
		temp = "";
	}

	public static String reverseString(String string) {

		temp = "";
		int length = 0;
		try {
			for (int i = 0;; i++) {
				string.charAt(i);
				length++;
			}
		} catch (IndexOutOfBoundsException iobe) {
			// Functioning normally
		}
		for (int i = 0; i < length; i++) {
			temp += string.charAt(length - 1 - i);
		}
		return temp;
	}

	// Because I can
	public static String THECOOLWAY(String string) {
		for (int i = commitment; i >= 0; i--) {
			try {
				temp += "" + string.charAt(i);
			} catch (Exception e) {
			}
		}
		return temp;
	}

	// Sometimes they call me "The Legend"
	public static String THECOOLESTWAY(String string) {
		possibleLength = commitment;
		for (;;) {
			char[] myChars = new char[possibleLength];
			for (int i = 0; i < possibleLength; i++) {
				try {
					myChars[i] = string.charAt(i);
					shuffleChars(myChars);
					runCounter++;
					if (checkEquality(myChars, string)) {
						for (int j = 0; j < possibleLength; j++) {
							temp += myChars[j];
						}
						System.out.println("This only took: " + runCounter + " attempts");
						return temp;
					}
				} catch (IndexOutOfBoundsException iobe) {
					possibleLength--;
				}
			}
		}
	}

	private static char[] shuffleChars(char[] myChars) {

		int random1 = (int) (Math.random() * possibleLength);
		int random2 = (int) (Math.random() * possibleLength);
		try {
			char temp = myChars[random1];
			myChars[random1] = myChars[random2];
			myChars[random2] = temp;
			return myChars;
		} catch (IndexOutOfBoundsException iobe) {
		}
		return myChars;
	}

	private static boolean checkEquality(char[] myChars, String string) {
		for (int i = 0; i < possibleLength; i++) {
			if (myChars[i] != string.charAt(possibleLength - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
