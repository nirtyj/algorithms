package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddBoldTagTest {

	@Test
	public void test() {
		AddBoldTag b = new AddBoldTag();
		String[] dict = {"abc","123"};
		assertEquals("<b>abc</b>xyz<b>123</b>", b.addBoldTag("abcxyz123", dict));
	}
	
	@Test
	public void test2() {
		AddBoldTag b = new AddBoldTag();
		String[] dict = {"aaa","aab","bc"};
		assertEquals("<b>aaabbc</b>c", b.addBoldTag("aaabbcc", dict));
	}

}
