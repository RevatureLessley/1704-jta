package com.revature.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.solutions.Factorial;

public class FactorialTests {

	@Test
	public void factorialRecursiveTest() {
		assertTrue(Factorial.factorialRecursive(5) == 120);
	}
	
	@Test
	public void factorialIterativeTest() {
		assertTrue(Factorial.factorialIterative(5) == 120);
	}

}
