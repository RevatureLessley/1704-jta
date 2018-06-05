package com.revature.solutions;

public class SwapCharacters {

	public static String modifyString(String string) {
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i < string.length(); i += 2) {
			answer.append(string.charAt(i));
			answer.append(string.charAt(i - 1));
			if ((i + 2) < string.length())
				answer.append(" ");
		}
		
		if (string.length() % 2 == 1) {
			answer.append(" ");
			answer.append(string.charAt(string.length() - 1));
		}
		
		return answer.toString();
	}
}
