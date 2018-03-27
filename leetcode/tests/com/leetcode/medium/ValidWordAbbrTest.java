package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidWordAbbrTest {

	@Test
	public void test() {
		String[] dictionary = {"deer", "door", "cake", "card"};
		ValidWordAbbr a = new ValidWordAbbr(dictionary);
		assertFalse(a.isUnique("dear")); //-> false
		assertTrue(a.isUnique("cart")); //-> true
		assertFalse(a.isUnique("cane")); //-> false
		assertTrue(a.isUnique("make")); //-> true
	}

}
