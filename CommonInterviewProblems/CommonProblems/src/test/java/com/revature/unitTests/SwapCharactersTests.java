package com.revature.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.solutions.SwapCharacters;

public class SwapCharactersTests {

	@Test
	public void SwapCharactersOddTest() {
		assertTrue("iW ll ai m".equals(SwapCharacters.modifyString("William")));
	}

	@Test
	public void SwapCharactersEvenTest() {
		assertTrue("sa fd hg kj".equals(SwapCharacters.modifyString("asdfghjk")));
	}

}
