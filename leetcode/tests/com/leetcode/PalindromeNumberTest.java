package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.PalindromeNumber;

public class PalindromeNumberTest {

	@Test
	public void test() {
		assertEquals(true , PalindromeNumber.isPalindrome(131));
		assertEquals(false , PalindromeNumber.isPalindrome(1445));
		assertEquals(true , PalindromeNumber.isPalindrome(1441));
	}

}
