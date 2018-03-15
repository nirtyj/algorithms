package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.RepeatedStringMatch;

public class RepeatedStringMatchTest {

	@Test
	public void test() {
		assertEquals(3, RepeatedStringMatch.repeatedStringMatch("abcd", "cdabcdab"));
	}

}
