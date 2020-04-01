package com.leetcode.sliding_window;

import org.junit.Test;

import java.util.List;

public class FindAllAnagramsInAStringTest {

    @Test
    public void test() {
        FindAllAnagramsInAString ana = new FindAllAnagramsInAString();
        List<Integer> vals = ana.findAnagrams("cbaebabacd", "abc");
        System.out.println();
    }

}
