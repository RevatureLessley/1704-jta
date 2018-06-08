package main;

public class Fibonacci {
	public static int iterative(int index) {
		if( index == 0 )
			return 1;
		else if( index == 1)
			return 1;
		
		return 2;
	}
	
	public static int recursive(int index) {
		if(index == 0 || index == 1)
			return 1;
		else
			return recursive(index-1) + recursive( index-2 );
	}
}
