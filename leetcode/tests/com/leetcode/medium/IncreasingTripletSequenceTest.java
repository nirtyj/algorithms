package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IncreasingTripletSequenceTest {

    @Test
    public void test() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        IncreasingTripletSequence_334 seq = new IncreasingTripletSequence_334();
        assertTrue(seq.increasingTriplet(nums));
    }
}
