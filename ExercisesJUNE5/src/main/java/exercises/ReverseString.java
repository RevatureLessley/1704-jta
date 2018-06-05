package exercises;

public class ReverseString {
	
	private static String reverse = "";
	
	public static String reverseString(String myString) {
		if(myString.length()==0) {
			String myStringReversed = reverse;
			reverse= "";
			return myStringReversed;
		}
		reverse += myString.charAt(myString.length()-1);
		return reverseString(myString.substring(0, myString.length()-1));
		
	}

}
