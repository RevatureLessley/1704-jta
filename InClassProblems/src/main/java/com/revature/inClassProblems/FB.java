package com.revature.inClassProblems;

public class FB {

	
	public static void fizzBuzz(int a, int b, int numberToFizz) {
		for (int i = 1; i <= numberToFizz; i++) {
			if (i % (a*b) == 0) {
				System.out.println("FIZZBUZZ!");
			}
			else if (i % a == 0) {
				System.out.println("fizz");
			}
			else if (i % b == 0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		fizzBuzz(3,7,300);
	}
}
