package com.leetcode;

import com.leetcode.medium.RemoveDuplicatesFromSortedArrayII_80;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayIITest {

    @Test
    public void test() {
        int[] arr = {1, 2};
        assertEquals(2, RemoveDuplicatesFromSortedArrayII_80.removeDuplicates(arr));
    }

    @Test
    public void test2() {
        int[] arr = {1, 1, 1};
        assertEquals(2, RemoveDuplicatesFromSortedArrayII_80.removeDuplicates(arr));
    }

    @Test
    public void test3() {
        int[] arr = {1, 1, 1, 2};
        assertEquals(3, RemoveDuplicatesFromSortedArrayII_80.removeDuplicates(arr));
    }

    @Test
    public void test4() {
        int[] arr = {1, 1, 1, 2, 3};
        assertEquals(3, RemoveDuplicatesFromSortedArrayII_80.removeDuplicates(arr));
    }

}
