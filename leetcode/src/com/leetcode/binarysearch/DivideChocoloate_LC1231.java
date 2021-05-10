package com.leetcode.binarysearch;

import java.util.Arrays;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
 *
 * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece consists of some consecutive chunks.
 *
 * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
 *
 * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * Example 2:
 *
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * Example 3:
 *
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 */
public class DivideChocoloate_LC1231 {

    /**
     * @param sweetness
     * @param K
     * @return
     */
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1;
        int pieces = K + 1;
        int right = Arrays.stream(sweetness).sum() / pieces;
        while(left < right){
            int middle = (left + right + 1) / 2;
            int cuts = getPieces(sweetness, middle, pieces);
            if (cuts >= pieces){
                left = middle;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }

    int getPieces(int[] sweetness, int sweetAlloted, int maxPieces){
        int piecesFound = 0;
        int sum = 0;
        for(int i : sweetness){
            sum = sum + i;
            if (sum >= sweetAlloted){
                piecesFound++;
                sum = 0;
            }
            // optimization don't need to find all cuts above max. just break
            if (piecesFound >= maxPieces){
                break;
            }
        }
        return piecesFound;
    }
}
