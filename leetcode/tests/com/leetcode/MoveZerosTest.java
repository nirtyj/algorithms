package com.leetcode;

import com.leetcode.easy.MoveZeros;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MoveZerosTest {

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 3, 12};
        MoveZeros.moveZeroes(arr);
        assertEquals("[1, 3, 12, 0, 0]", Arrays.toString(arr));
    }

}
