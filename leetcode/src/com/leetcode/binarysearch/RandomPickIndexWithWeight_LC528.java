package com.leetcode.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * For example, given an input list of values [1, 9], when we pick up a number out of it, the chance is that 9 times
 * out of 10 we should pick the number 9 as the answer.
 *
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 */
public class RandomPickIndexWithWeight_LC528 {

    int[] arr;
    int max = 0;
    Random random = new Random();
    public RandomPickIndexWithWeight_LC528(int[] w) {
        int[] arr = new int[w.length];
        arr[0] = w[0];
        max += w[0];
        for (int i = 1; i < w.length; i++) {
            arr[i] = arr[i - 1] + w[i];
            max += w[i];
        }
        this.arr = arr;
    }

    /**
     * O(nlogn)
     * @return
     */
    public int pickIndex() {
        int rnd = random.nextInt(max) + 1;  // generate random number in [1,max]
        //this returns the index of the random  number,
        //if the number does not exist in the array it returns  -(the position it should have been) - 1
        int ret = Arrays.binarySearch(arr, rnd);
        if (ret < 0)
            ret = -ret - 1; //if not in the array index = (-(insertion point) - 1).
        return ret;
    }
}
