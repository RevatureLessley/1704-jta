package exercises;

public class CharacterSwap {

	public static void main(String[] args) {
		System.out.println(modifyString("andy"));
	}
	
	public static String modifyString(String s) {
		String newString = "";
		for(int i = 0; i < s.length(); i++) {
			newString += (i % 2 == 0) ? (i==s.length()-1) ? s.charAt(i) : s.charAt(i+1) : s.charAt(i-1)+" ";
		}
		return newString.trim();
	}

}
