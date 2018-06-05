package com.revature.unitTests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.revature.solutions.Fibonacci;

public class FibonacciTests {

	@Test
	public void iterativeFibTest() {
		assertTrue(Fibonacci.iterativeFib(9) == 34);
	}

	@Test
	public void recursiveFibTest() {
		assertTrue(Fibonacci.recursiveFib(9) == 34);
	}

}
