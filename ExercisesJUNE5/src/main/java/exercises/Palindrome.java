package exercises;

public class Palindrome {
	
	public static boolean isPalindrome(String palindrome) {
		if(palindrome.length()==0 || palindrome.length() == 1) {
			return true;
		}
		palindrome = palindrome.toLowerCase().replace(" ", "");
		char front = palindrome.charAt(0);
		char last = palindrome.charAt(palindrome.length()-1);
		if(front != last) {
			return false;
		}
		return isPalindrome(palindrome.substring(1, palindrome.length()-1));
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A Santa at Nasa"));
	}

}
