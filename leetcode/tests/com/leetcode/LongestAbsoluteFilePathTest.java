package com.leetcode;

import com.leetcode.medium.LongestAbsoluteFilePath_388;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestAbsoluteFilePathTest {

    @Test
    public void test() {
        assertEquals(32, LongestAbsoluteFilePath_388.lengthLongestPath(
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));

    }

}
