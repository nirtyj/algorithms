package com.leetcode;

import com.leetcode.easy.RepeatedStringMatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepeatedStringMatchTest {

    @Test
    public void test() {
        assertEquals(3, RepeatedStringMatch.repeatedStringMatch("abcd", "cdabcdab"));
    }

}
