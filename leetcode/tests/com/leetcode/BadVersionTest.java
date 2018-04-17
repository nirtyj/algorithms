package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.binarysearch.BadVersion;

public class BadVersionTest {

	@Test
	public void test() {
		BadVersion v = new BadVersion(3);
		assertEquals(3, v.firstBadVersion(3));
	}

}
