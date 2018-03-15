package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.medium.LongestAbsoluteFilePath;

public class LongestAbsoluteFilePathTest {

	@Test
	public void test() {
		assertEquals(32, LongestAbsoluteFilePath.lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

	}

}
