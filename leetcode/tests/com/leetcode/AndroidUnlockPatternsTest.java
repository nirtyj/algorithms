package com.leetcode;

import com.leetcode.medium.AndroidUnlockPatterns;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AndroidUnlockPatternsTest {

    @Test
    public void test() {
        //assertEquals(9, AndroidUnlockPatterns.numberOfPatterns(1, 1));
        //assertEquals(65, AndroidUnlockPatterns.numberOfPatterns(1, 2));
        assertEquals(2009, AndroidUnlockPatterns.numberOfPatterns(1, 4));
    }

}
