package com.leetcode.sliding_window;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutationsInAStringTest {

	@Test
	public void test() {
		PermutationsInAString ps = new PermutationsInAString();
		assertFalse(ps.checkInclusion("ab", "eidboaooo"));
	}
	
	@Test
	public void test2() {
		PermutationsInAString ps = new PermutationsInAString();
		assertTrue(ps.checkInclusion("ab", "eidbaooo"));
	}

	@Test
	public void test3() {
		PermutationsInAString ps = new PermutationsInAString();
		assertTrue(ps.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));
	}
}
