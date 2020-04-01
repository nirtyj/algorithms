package com.leetcode;

import com.leetcode.easy.ReverseVowelsOfString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseVowelsOfStringTest {

    @Test
    public void test() {
        assertEquals("leotcede", ReverseVowelsOfString.reverseVowels("leetcode"));
    }

}
