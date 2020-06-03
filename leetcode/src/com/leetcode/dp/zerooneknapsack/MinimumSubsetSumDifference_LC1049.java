package com.leetcode.dp.zerooneknapsack;

/**
 * Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 *
 * Last Stones 2
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 */
public class MinimumSubsetSumDifference_LC1049 {

    /**
     * Bottom up DP with space optimization
     */
    public int lastStoneWeightII(int[] nums) {
        int totalSum = 0;
        for(int i: nums){
            totalSum += i;
        }
        int halfSum = totalSum/2;
        int maxToHalfSum = 0;
        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int c = halfSum; c >= 0; c--) {
                boolean without = dp[c];
                boolean with = false;
                if (c == nums[i]){
                    with = true;
                } else if (c > nums[i]) {
                    int withRemC = c - nums[i];
                    with = dp[withRemC];
                }
                dp[c] = with | without;
                if (dp[c]) {
                    maxToHalfSum = Math.max(c, maxToHalfSum);
                    if (c == halfSum){
                        break;
                    }
                }
            }
        }

        int otherPartitionSum = totalSum - maxToHalfSum;
        return Math.abs(otherPartitionSum-maxToHalfSum);
    }


    /**
     * Bottom up DP with no space optimization
     * @param nums
     * @return
     */
    public int getPartitionMinDifference(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum = totalSum + i;
        }
        int halfSum = totalSum / 2;
        int maxToHalfSum = -1;
        boolean[][] dp = new boolean[nums.length][halfSum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= halfSum)
            dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int c = 0; c <= halfSum; c++) {
                boolean without = dp[i - 1][c];
                boolean with = false;
                if (c >= nums[i]) {
                    int withRemC = c - nums[i];
                    with = dp[i - 1][withRemC];
                }
                dp[i][c] = with | without;
                if (dp[i][c])
                    maxToHalfSum = Math.max(c, maxToHalfSum);
            }
        }

        int otherPartitionSum = totalSum - maxToHalfSum;
        return Math.abs(otherPartitionSum-maxToHalfSum);
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifference_LC1049 ps = new MinimumSubsetSumDifference_LC1049();
        int[] num = { 9, 3, 2, 1};
        System.out.println(ps.getPartitionMinDifference(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.getPartitionMinDifference(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.getPartitionMinDifference(num));
    }
}
