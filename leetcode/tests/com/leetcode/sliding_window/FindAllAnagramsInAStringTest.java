package com.leetcode.sliding_window;

import org.junit.Test;

import java.util.List;

public class FindAllAnagramsInAStringTest {

    @Test
    public void test() {
        FindAllAnagramsInAString_LC438 ana = new FindAllAnagramsInAString_LC438();
        List<Integer> vals = ana.findAnagrams("cbaebabacd", "abc");
        System.out.println();
    }

}
