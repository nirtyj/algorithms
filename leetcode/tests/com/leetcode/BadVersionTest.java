package com.leetcode;

import com.leetcode.binarysearch.BadVersion_LC278;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadVersionTest {

    @Test
    public void test() {
        BadVersion_LC278 v = new BadVersion_LC278(3);
        assertEquals(3, v.firstBadVersion(3));
    }

}
