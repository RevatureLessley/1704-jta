package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Swap;

public class SwapTest {
	@Test
	public void test() {
		assertEquals("iW ll aim", Swap.swap("William"));
		assertEquals("im ll oin", Swap.swap("million"));
		assertEquals("gla  oln", Swap.swap("gallon"));
		assertEquals("gli  sl", Swap.swap("gills"));
	}
}
