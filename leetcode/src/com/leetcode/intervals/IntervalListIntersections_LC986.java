package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 */
public class IntervalListIntersections_LC986 {

    /**
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length){
            int Astart = A[i][0];
            int Aend = A[i][1];
            int Bstart = B[j][0];
            int Bend = B[j][1];
            if (Astart > Bend) { // if there are no overlap
                j++;
                continue;
            } else if (Bstart > Aend) { // if there are no overlap
                i++;
                continue;
            }
            int[] arr = {Math.max(Astart, Bstart), Math.min(Aend, Bend)};
            result.add(arr);
            if (Aend < Bend) { // increment if A or B based on the lowest end value.
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
