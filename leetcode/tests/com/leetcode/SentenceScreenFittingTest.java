package com.leetcode;

import com.leetcode.medium.SentenceScreenFitting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SentenceScreenFittingTest {

    @Test
    public void test() {
        String[] arr = {"a", "bcd", "e"};
        assertEquals(2, SentenceScreenFitting.wordsTyping(arr, 3, 6));
    }

    @Test
    public void test2() {
        String[] arr = {"hello", "world"};
        assertEquals(1, SentenceScreenFitting.wordsTyping(arr, 2, 8));
    }

    @Test
    public void test3() {
        String[] arr = {"I", "had", "apple", "pie"};
        assertEquals(1, SentenceScreenFitting.wordsTyping(arr, 4, 5));
    }
}
