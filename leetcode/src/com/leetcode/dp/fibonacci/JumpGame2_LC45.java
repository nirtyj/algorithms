package com.leetcode.dp.fibonacci;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGame2_LC45 {

    /**
     * Leetcode verified O(n) - https://www.youtube.com/watch?v=vBdo7wtwlXs
     * try to get the most max possible for next turn, until you finish the chosen max.
     *
     * @param
     * @return
     */
    public int jump(int[] jumps) {
        if (jumps.length == 1){
            return 0;
        }
        int nextMaxReachEnd = 0;
        int maxReachFromHere = 0;
        int count = 0;
        for(int i=0;i<jumps.length-1;i++){
            if (maxReachFromHere >= jumps.length-1){
                break;
            }
            nextMaxReachEnd = Math.max(i + jumps[i], nextMaxReachEnd);
            if(i == maxReachFromHere){
                count++;
                maxReachFromHere = nextMaxReachEnd;
            }
        }
        return count;
    }

    /**
     * O(n*2)
     * @param jumps
     * @return
     */
    public int jumpOn2(int[] jumps) {
        int[] dp = new int[jumps.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<jumps.length;i++) {
            int jump = jumps[i];
            for(int j = i + 1; j<= i + jump && j<jumps.length; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[jumps.length - 1];
    }
}
