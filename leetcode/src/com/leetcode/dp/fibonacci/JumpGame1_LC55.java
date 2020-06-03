package com.leetcode.dp.fibonacci;

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
public class JumpGame1_LC55 {

    /**
     * O(n)
     * @param A
     * @return
     */
    public static boolean canJump(int[] A) {
        if (A.length <= 1)
            return true;
        int maxFromHere = 0;
        for (int i=0;i<A.length;i++){
            if (maxFromHere == i && A[i] == 0){
                return false;
            }
            maxFromHere = Math.max(maxFromHere, i + A[i]);
            if (maxFromHere>=A.length-1){
                return true;
            }
        }
        return false;
    }
}
