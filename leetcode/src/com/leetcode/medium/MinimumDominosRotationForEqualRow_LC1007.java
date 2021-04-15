package com.leetcode.medium;


public class MinimumDominosRotationForEqualRow_LC1007 {

    /**
     * Count for each number if it exceeds the length. then yes. its possible to rotate.
     * then find the min required to rotate
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], countC = new int[7];
        for (int i = 0; i < A.length; ++i) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) {
                countC[A[i]]++;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            if (countA[i] + countB[i] - countC[i] >= A.length) {
                result = Math.min(result, Math.min(A.length - countA[i], A.length - countB[i]));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
