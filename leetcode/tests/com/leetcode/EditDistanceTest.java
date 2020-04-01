package com.leetcode;

import com.leetcode.hard.EditDistance;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

    @Test
    public void test() {
        assertEquals(1, EditDistance.minDistance("", "a"));
    }

}
