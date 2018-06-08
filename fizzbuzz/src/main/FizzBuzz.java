package main;

public class FizzBuzz {
	public static String fb(int index) {
		String[] words = new String[101];
		
		for(int i = 1; i < 101; i++) {
			if(i % 3 == 0) {
				if(i % 5 == 0)
					words[i] = "FizzBuzz";
				else
					words[i] = "Fizz";
			}
			else
				words[i] = "Buzz";
		}
		
		return words[index];
	}
}
