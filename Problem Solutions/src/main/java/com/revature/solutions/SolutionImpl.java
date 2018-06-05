package com.revature.solutions;


public class SolutionImpl{

	private SolutionImpl() {
		
	}
	public static boolean isPalindrome(String pal) {
		pal = pal.toLowerCase();
		StringBuilder bill = new StringBuilder();
		
		for(int i =pal.length()-1; i >= 0;i--) {
			bill.append(pal.charAt(i));
		}
		return pal.equals(bill.toString());
	}

	public static String reverseString(String forward) {
		String backward="";
		for(int i =forward.length()-1; i >= 0;i--) {
			
			backward += forward.charAt(i);
		}	
		return backward;
	}

	public static int iterativeFib(int fib) {
		int firstDigit = 1;
		int secondDigit = 1;
		if(fib == 0) {
			return 0;
		}
		else if (fib == 1) {
			return 1;
		}
		else {
		fib -=2;
		while( --fib >= 0) {
			firstDigit  += secondDigit;
			if(--fib >= 0)
				secondDigit += firstDigit;
				
		}
		}
		return (firstDigit > secondDigit) ? firstDigit : secondDigit;
	}

	public static int recursiveFib(int fib) {
		return (fib > 0) ? (fib > 1) ? (fib > 2) ?  recursiveFib(fib-2)+ recursiveFib(--fib) : 1 : 1 : 0;
	}

	public static void fizzBuzz() {
		for(int i = 1; i < 101; i++) 
			System.out.println((i % 3 == 0) ? (i % 5 == 0) ? "FizzBuzz" : "Fizz" : ((i % 5 == 0) ? "Buzz" : i));	
	}
	
	public static int factorial(int factor) {
		return (factor <= 0) ? 1:factorial(factor-1)*factor;
	}
	
	public static String modifyString(String mod) {
		StringBuilder bill = new StringBuilder();
		if(mod.length() % 2 ==0) {
		for(int i = 0; i+1 < mod.length();i+=2) {
		bill.append(mod.charAt(i+1));
		bill.append(mod.charAt(i));
		bill.append(" ");
		}
		bill.deleteCharAt((bill.length()-1));
		}
		else {
			for(int i = 0; i+1 < mod.length();i+=2) {
				bill.append(mod.charAt(i+1));
				bill.append(mod.charAt(i));
				bill.append(" ");	
		}
			bill.append(mod.charAt(mod.length()-1));
		}
		return bill.toString();
	}

 @SuppressWarnings("finally")
public static String modString(String mod) {
	 String modedString = "";
	 int i;
	 try {
		for(i=0;i < mod.length();i+=2){
			String temp = mod.substring(i, i+2);
			temp = temp.concat(String.valueOf(temp.charAt(0)));
			temp = temp.substring(1,3);
			modedString+= temp + " ";
		}
	 }catch(StringIndexOutOfBoundsException sioobe){
			 modedString += mod.charAt(mod.length()-1);
	 }finally{
		 return modedString.trim();
	 }
 }
 public static void main(String[] args) {
	 
	 System.out.println(modString("William"));
	System.out.println(modString("Daniel"));
}
}
