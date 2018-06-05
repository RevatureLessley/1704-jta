package com.revature.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.solutions.Reverse;

public class ReverseTests {

	@Test
	public void reverseStringTest() {
		assertTrue("lkjhgfdsa".equals(Reverse.reverseString("asdfghjkl")));
	}

}
