package com.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.
 *
 * You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 */
public class LeftmostColumnWithAtLeastAOne_LC1428 {
    // sample class
    class BinaryMatrix {
      public int get(int row, int col){return 0;};
      public List<Integer> dimensions(){return new ArrayList<>();};
    };

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<rows;i++) {
            int colFound = getIndexOfOneInRow(binaryMatrix, i, 0, cols - 1);
            if (binaryMatrix.get(i, colFound) == 1) {
                min = Math.min(min, colFound);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private int getIndexOfOneInRow(BinaryMatrix binaryMatrix, int row, int leftCol, int rightCol) {
        if (leftCol == rightCol) {
            return leftCol;
        }
        int middle = ((leftCol + 1 + rightCol + 1) / 2) -1;
        if (binaryMatrix.get(row, middle) == 1) {
            return getIndexOfOneInRow(binaryMatrix, row, leftCol, middle);
        } else {
            return getIndexOfOneInRow(binaryMatrix, row, middle + 1, rightCol);
        }
    }
}
