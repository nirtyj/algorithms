package com.leetcode.medium;

/**
 * 835. https://leetcode.com/problems/image-overlap/description/
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 * <p>
 * (Note also that a translation does not include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 */
public class ImageOverlap_835 {

    /**
     * Leetcode verified
     *
     * @param A
     * @param B
     * @return
     */
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int sum = countMatches(A, 0, A.length, 0, A[0].length, B, i, B.length, j, B[0].length);
                max = Math.max(max, sum);
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                int sum = countMatches(B, 0, B.length, 0, B[0].length, A, i, A.length, j, A[0].length);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private int countMatches(int[][] A, int ist, int iend, int jst, int jend, int[][] B, int mst, int mend, int nst,
                             int nend) {
        int sum = 0;
        while (mst < mend) {
            int st = nst;
            int st2 = jst;
            while (st < nend) {
                if (A[ist][st2] == 1 && B[mst][st] == A[ist][st2]) {
                    sum++;
                }
                st2++;
                st++;
            }
            ist++;
            mst++;
        }
        return sum;
    }
}
