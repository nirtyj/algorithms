package com.leetcode;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.leetcode.easy.ValidWordSquare;

public class ValidWordSquareTest {

	@Test
	public void test() {
		String[] arr = {"abcd","bnrt","crm","dt"};
		assertTrue(ValidWordSquare.validWordSquare(Arrays.asList(arr)));
	}

}
