package com.leetcode;

import com.leetcode.medium.MajorityElementII_229;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MajorityElementTest {

    @Test
    public void test() {
        int[] input = {2, 2};
        List<Integer> results = MajorityElementII_229.majorityElement(input);
        assertEquals(2, results.get(0).intValue());
    }

    @Test
    public void test2() {
        int[] input = {1, 2};
        List<Integer> results = MajorityElementII_229.majorityElement(input);
        assertEquals(1, results.get(0).intValue());
        assertEquals(2, results.get(1).intValue());
    }
}
