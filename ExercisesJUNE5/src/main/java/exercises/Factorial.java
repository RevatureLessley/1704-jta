package exercises;

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println(factorial(0));
	}
	
	public static int factorial(int num) {
		int hold = num;
		for(int i = --num; i > 0; i --) {
			hold *= i;
		}
		return hold;
	}
}
