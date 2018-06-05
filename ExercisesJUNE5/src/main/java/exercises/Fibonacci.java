package exercises;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(recursive(0));
	}
	
	public static int recursive(int n) {
		return n = (n <= 2) ? (n==0)? 0 : 1 : recursive(n-1) + recursive(n-2);
	}
	
	public static int iterative(int num) {
		if(num == 0) {
			return 0;
		}
		if (num==1 || num==2)
			return 1;
		int first=0;
		int second=1;
		for (int i=0; i<num/2; i++){
			first = first+second;
			second = second+first;
		}
		if(num % 2 == 0 )
			return first;
		else
			return second;
	}
}
