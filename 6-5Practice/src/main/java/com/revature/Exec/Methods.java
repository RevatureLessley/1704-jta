package com.revature.Exec;

public class Methods {

	public void fizzBuzz(){
		for(int i=1;i<=100;i++) {
			if(i%3==0&&i%5==0) {
				System.out.println(i+") FizzBuzz");
			}
			else if(i%3==0) {
				System.out.println(i+") Fizz");
			}
			else if(i%5==0) {
				System.out.println(i+") Buzz");
			}
			else System.out.println(i+")");
			
		}
	}
	
	public boolean isPalindrome(String in) {
		String reverse=reverseString(in);
		return(reverse.equals(in));
		
	}
	
	public String reverseString(String in) {
		String reverse="";
		for(int i=in.length()-1;i>=0;i--) {
			reverse=reverse+in.charAt(i);
		}
		return reverse;
	}
	
	public int iterativeFib(int n) throws NonPositiveValueException{
			if (n<=0) throw new NonPositiveValueException("Positive values only");
			if (n==1||n==2) return 1;
			int onePrior=1, twoPrior=1, current=0;
			for(int i=3;i<=n;i++) {
				current=onePrior+twoPrior;
				twoPrior=onePrior;
				onePrior=current;			
			}
			return current;
	}
	
	public int recursiveFib(int n) throws NonPositiveValueException{
			if (n<=0) throw new NonPositiveValueException("Positive values only");
			if (n==1||n==2) return 1;
			else return recursiveFib(n-1)+recursiveFib(n-2);
	}
	
	public int factorial(int n) throws NonPositiveValueException{
			if(n<=0) throw new NonPositiveValueException("Positive values only");
			int result=1;
			for(int i=1;i<=n;i++) {
				result*=i;
			}
			return result;
	}
	
	public String modifyString(String in) {
		String mod="";
		for(int i=0;i<in.length();i=i+2) {
			if(i==in.length()-1) {
				mod+=in.charAt(i);
				break;
			}
			mod+=in.charAt(i+1);
			mod+=in.charAt(i);
			if(i<in.length()-2) {
				mod+=" ";
			}
		}
		return mod;
	}
}
