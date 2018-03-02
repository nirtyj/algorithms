package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromicSubstringsTest {

	@Test
	public void test() {
		assertEquals(3, PalindromicSubstrings.countSubstrings2("abc"));
		assertEquals(6, PalindromicSubstrings.countSubstrings2("aaa"));
	}

}
