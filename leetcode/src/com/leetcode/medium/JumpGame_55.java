package com.leetcode.medium;

/**
 * 55. https://leetcode.com/problems/jump-game/description/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame_55 {

    /**
     * Leetcode verified
     *
     * @param A
     * @return
     */
    public static boolean canJump(int[] A) {
        if (A.length <= 1)
            return true;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {

            // failure case - max is less than equal to current step but current step is 0
            if (max <= i && A[i] == 0)
                return false;

            /**
             * is it worth going to next step and jump from there ? do we get updated max.
             */
            int reachFromHere = i + A[i];
            max = Math.max(max, reachFromHere);

            // success case
            if (max >= A.length - 1)
                return true;
        }
        return false;
    }
}
