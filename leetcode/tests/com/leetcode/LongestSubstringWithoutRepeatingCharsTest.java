package com.leetcode;

import com.leetcode.sliding_window.LongestSubstringWithoutRepeatingCharacters_LC3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharsTest {

    @Test
    public void test() {
        LongestSubstringWithoutRepeatingCharacters_LC3 s = new LongestSubstringWithoutRepeatingCharacters_LC3();
        String st = "abcabcbb";
        assertEquals(3, s.lengthOfLongestSubstring(st));
    }

}
