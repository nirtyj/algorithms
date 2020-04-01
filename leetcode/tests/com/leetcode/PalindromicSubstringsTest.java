package com.leetcode;

import com.leetcode.medium.PalindromicSubstrings_647;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromicSubstringsTest {

    @Test
    public void test() {
        assertEquals(3, PalindromicSubstrings_647.countSubstrings2("abc"));
        assertEquals(6, PalindromicSubstrings_647.countSubstrings2("aaa"));
    }

}
