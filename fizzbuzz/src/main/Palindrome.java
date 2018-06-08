package main;

public class Palindrome {
	public static boolean test(String string) {
		string = string.replace(" ", "")
				.replace("?", "")
				.replace("!", "")
				.replace(",", "")
				.toLowerCase();
		StringBuilder builder = new StringBuilder(string);
		String reverse = builder.reverse().toString();
		
		if(string.equals(reverse))
			return true;
		
		return false;
	}
}
