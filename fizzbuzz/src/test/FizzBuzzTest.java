package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.FizzBuzz;

public class FizzBuzzTest {
	@Test
	public void test() {
		assertEquals(FizzBuzz.fb(3), "Fizz" );
		assertEquals(FizzBuzz.fb(5), "Buzz" );
		assertEquals(FizzBuzz.fb(15), "FizzBuzz" );
	}

}
