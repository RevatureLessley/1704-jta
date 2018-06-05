package com.revature.implementation;

public class Fizzy {

	public static void fizzBuzz() {
		for(int i = 1; i <= 100; i++) {
			System.out.print("\n" + i);
			
			if(i%3 == 0 && i%5 == 0)
				System.out.print("	FizzBuzz");
			else if(i%3 == 0)
				System.out.print("	Fizz");
			else if(i%5 == 0)
				System.out.print("	Buzz");

		}
	}

}
