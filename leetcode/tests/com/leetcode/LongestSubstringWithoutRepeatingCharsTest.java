package com.leetcode;

import com.leetcode.sliding_window.LongestSubstringWithoutRepeatingCharacters;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharsTest {

    @Test
    public void test() {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String st = "abcabcbb";
        assertEquals(3, s.lengthOfLongestSubstring(st));
    }

}
