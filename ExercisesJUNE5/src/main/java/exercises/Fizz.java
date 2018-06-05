package exercises;

public class Fizz {

	public static void main(String[] args) {
		FizzBuzz();
	}
	
	public static void FizzBuzz() {
		for(int i= 0; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0)
				System.out.println(i+" FizzBuzz");
			else if(i % 3 == 0)
				System.out.println(i+" Fizz");
			else if(i % 5 == 0)
				System.out.println(i+" Buzz");
			else
				System.out.println(i);
		}
	}

}
