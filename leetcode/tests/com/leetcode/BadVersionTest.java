package com.leetcode;

import com.leetcode.binarysearch.BadVersion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadVersionTest {

    @Test
    public void test() {
        BadVersion v = new BadVersion(3);
        assertEquals(3, v.firstBadVersion(3));
    }

}
