package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.LisenceKeyFormatting;

public class LisenceKeyFormattingTest {

	@Test
	public void test() {
		assertEquals("2-5G-3J", LisenceKeyFormatting.licenseKeyFormatting("2-5g-3-J", 2));
	}

}
