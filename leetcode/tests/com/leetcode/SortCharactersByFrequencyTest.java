package com.leetcode;

import com.leetcode.medium.SortCharactersByFrequency_451;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortCharactersByFrequencyTest {

    @Test
    public void test() {
        assertEquals("eeeeaaarrd", SortCharactersByFrequency_451.frequencySort("raaeaedere"));
    }

}
