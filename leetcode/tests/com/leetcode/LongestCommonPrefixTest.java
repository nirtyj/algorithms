package com.leetcode;

import com.leetcode.easy.LongestCommonPrefix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {

    @Test
    public void test() {
        String[] arr = {"aa", "ab"};
        assertEquals("a", LongestCommonPrefix.longestCommonPrefix(arr));
    }

    @Test
    public void test1() {
        String[] input = {"interspecies", "interstellar", "interstate"};
        assertEquals("inters", LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void test2() {
        String[] input = {"throne", "throne"};
        assertEquals("throne", LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void test3() {
        String[] input = {"throne", "dungeon"};
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void test4() {
        String[] input = {"cheese"};
        assertEquals("cheese", LongestCommonPrefix.longestCommonPrefix(input));
    }

    @Test
    public void test5() {
        String[] input = {"foo", "fooar"};
        assertEquals("foo", LongestCommonPrefix.longestCommonPrefix(input));
    }

}
