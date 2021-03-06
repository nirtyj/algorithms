package com.leetcode;

import com.leetcode.hard.Candy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyTest {

    @Test
    public void test() {
        int[] input = {1, 2, 1, 1, 3, 2, 1, 2, 1};
        assertEquals(14, Candy.candy(input));
    }

    @Test
    public void test1() {
        int[] input = {2, 4, 2, 2, 7, 4, 2, 5, 1};
        assertEquals(14, Candy.candy(input));
    }

}
