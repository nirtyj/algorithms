package com.leetcode.medium;

import com.leetcode.subarrays.ContiguousBinaryArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMaxLengthTest {

    @Test
    public void test() {
        int[] arr = {0, 1, 1};
        ContiguousBinaryArray m = new ContiguousBinaryArray();
        assertEquals(2, m.findMaxLength(arr));
    }

}
