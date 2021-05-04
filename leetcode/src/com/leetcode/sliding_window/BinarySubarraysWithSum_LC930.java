package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * n an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 */
public class BinarySubarraysWithSum_LC930 {

    /**
     * Atmost (s) is the count of subarrays whose sum <= s,
     * Atmost (s-1) is the count of subarrays whose sum <= s-1,
     * if you subtract them, all you get is subarrays whose sum exactly == s.
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSumTwoPass(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1) ;
    }

    public int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int result = 0, begin = 0, sum = 0;
        for (int end = 0; end < A.length; end++) {
            sum = sum + A[end];
            while (sum > S){
                sum = sum - A[begin];
                begin++;
            }
            result = result + (end - begin + 1);
        }
        return result;
    }

    /**
     * Prefix sum With two sum hashmap
     */
    public int numSubarraysWithSum(int[] A, int S) {
        int sumSoFar = 0;
        int result = 0;
        Map<Integer, Integer> presum = new HashMap<>(); // Two sum with Prefix sum
        for (int i : A) {
            sumSoFar = sumSoFar + i; // sum so far
            if (presum.get(sumSoFar - S) != null) {
                result = result + presum.get(sumSoFar - S);
            }
            if (sumSoFar == S) {
                result = result + 1;
            }
            presum.put(sumSoFar, presum.getOrDefault(sumSoFar, 0) + 1); // if none exists add 1. else previous + 1.
        }
        return result;
    }
}
