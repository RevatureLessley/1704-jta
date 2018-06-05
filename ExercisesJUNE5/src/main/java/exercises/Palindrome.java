package exercises;

public class Palindrome {
	
	public static boolean isPalindrome(String palindrome) {
		palindrome = palindrome.toLowerCase().replace(" ", "").trim();
		char front = palindrome.charAt(0);
		char last = palindrome.charAt(palindrome.length()-1);
		if(front != last) {
			return false;
		}
		return (palindrome.length() <= 1) ? true : isPalindrome(palindrome.substring(1, palindrome.length()-1));
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("race car"));
	}

}
