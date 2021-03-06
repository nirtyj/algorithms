package com.leetcode;

import com.leetcode.stacks.DecodeString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeStringTest {

    @Test
    public void test() {
        assertEquals("aaabcbc", DecodeString.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", DecodeString.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", DecodeString.decodeString("2[abc]3[cd]ef"));
        assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", DecodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

}
