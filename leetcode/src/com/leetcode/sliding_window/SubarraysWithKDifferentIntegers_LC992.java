package com.leetcode.sliding_window;

import java.util.HashMap;

/**
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.
 *
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 *
 * Return the number of good subarrays of A.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 *
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class SubarraysWithKDifferentIntegers_LC992 {

    /**
     * sliding windows are usually atmost K Distinct Chars.
     * So use that to solve with exactly k distinct chars.
     * @param A
     * @param K
     * @return
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }

    public int subarraysWithAtMostKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int begin = 0;
        int result = 0;
        for (int end = 0; end < A.length; end++) {
            map.put(A[end], map.getOrDefault(A[end], 0) + 1);
            while (map.size() > K && begin <= end) {
                map.put(A[begin], map.getOrDefault(A[begin], 0) - 1);
                if (map.get(A[begin]) == 0) {
                    map.remove(A[begin]);
                }
                begin++;
            }
            result = result + (end - begin + 1);
        }
        return result;
    }
}
