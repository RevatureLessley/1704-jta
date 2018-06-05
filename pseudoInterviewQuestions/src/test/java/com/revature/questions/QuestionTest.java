package com.revature.questions;


import org.junit.Test;

import static com.revature.questions.Questions.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class QuestionTest {


	@Test
	public void isPalindrome1() {
		assertTrue(isPalindrome("rats live on no evil star"));
	}

	@Test
	public void isPalindrome2() {
		assertFalse(isPalindrome("racercar"));
	}

	@Test
	public void isPalindrome3() {
		assertTrue(isPalindrome("racecar"));
	}

	@Test
	public void isPalindrome4() {
		assertTrue(isPalindrome(""));
	}

	@Test
	public void isPalindrome5() {
		assertTrue(isPalindrome("r"));
	}

	@Test
	public void isPalindrome6() {
		assertTrue(isPalindrome("lool"));
	}

	@Test
	public void reverseString1() {
		assertEquals("zzuBzziF", reverseString("FizzBuzz"));
	}

	@Test
	public void reverseString2() {
		assertEquals("f", reverseString("f"));
	}

	@Test
	public void reverseString3() {
		assertEquals("", reverseString(""));
	}


	@Test
	public void iterativeFib1() {
		assertEquals(0, iterativeFib(0));
	}

	@Test
	public void iterativeFib2() {
		assertEquals(1, iterativeFib(2));
	}

	@Test
	public void iterativeFib3() {
		assertEquals(1, iterativeFib(1));
	}

	@Test
	public void iterativeFib4() {
		assertEquals(8, iterativeFib(6));
	}

	@Test
	public void recursiveFib1() {
		assertEquals(0, iterativeFib(0));
	}

	@Test
	public void recursiveFib2() {
		assertEquals(1, iterativeFib(2));
	}

	@Test
	public void recursiveFib3() {
		assertEquals(1, iterativeFib(1));
	}

	@Test
	public void recursiveFib4() {
		assertEquals(8, iterativeFib(6));
	}

	@Test
	public void factorial1() {
		assertEquals(1, factorial(0));
	}

	@Test
	public void factorial2() {
		assertEquals(1, factorial(1));
	}

	@Test
	public void factorial3() {
		assertEquals(479001600, factorial(12));
	}

	@Test
	public void factorial4() {
		try {
			factorial(14);
		} catch (UnsupportedOperationException e) {
			return;
		}
		fail();
	}

	@Test
	public void factorial5() {
		try {
			factorial(-1);
		} catch (ArithmeticException e) {
			return;
		}
		fail();
	}

	@Test
	public void modifyString1() {
		assertEquals("iW ll ai m", modifyString("William"));
	}

	@Test
	public void modifyString2() {
		assertEquals("m", modifyString("m"));
	}

	@Test
	public void modifyString3() {
		assertEquals("mi ", modifyString("im"));
	}

	@Test
	public void modifyString4() {
		assertEquals("", modifyString(""));
	}


}