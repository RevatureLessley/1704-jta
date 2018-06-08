package main;

public class Factorial {	
	public static int iterative(int index) {
		if(index == 0)
			return 1;
		
		int result = 1;
		
		for(int i = index; i > 0; i--)
			result *= i;
		
		return result;
	}
	
	public static int recursive(int index) {
		if(index == 0)
			return 1;
		
		if(index == 1)
			return index;
		else
			return index * recursive( index - 1 );
	}
}
