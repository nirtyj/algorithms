package leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestAbsoluteFilePathTest {

	@Test
	public void test() {
		assertEquals(32, LongestAbsoluteFilePath.lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

	}

}
