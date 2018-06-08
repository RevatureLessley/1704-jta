package main;

public class Reverse {
	public static String test(String string) {
		
		int i = 0;
		while(true) {
			try {
				string.charAt(i);
			} catch(Exception e) {
				break;
			}
			i++;
		}
		
		char[] result = new char[i];
		
		i = i-1;
		int j = 0;
		while(true) {
			try {
				result[i] = string.charAt(j);
			} catch(Exception e) {
				break;
			}
			j++;
			i--;
		}
		
		
		
		return new String(result);
	}
}
