package com.leetcode.trees.segment_trees;

public class RangeSumQuery2DMutable_LC308 {

    /**
     * TODO - Binary indexed tree - Fenwick tree
     */

    /**
     * My solution - slow as it precomputes the values
     */
    static class NumMatrix {

        int[][] sum;
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0){
                return;
            }
            this.matrix = matrix;
            this.sum = new int[matrix.length][matrix[0].length];
            for(int i=0; i < matrix.length;i++) {
                for (int j=0; j< matrix[0].length;j++){
                    int top = (i-1 < 0) ? 0 : sum[i-1][j];
                    int left = (j-1 < 0) ? 0 : sum[i][j-1];
                    int topLeft = (i-1<0 || j -1 <0) ? 0 : sum[i-1][j-1];
                    sum[i][j] = top + left - topLeft+ matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            if (matrix[row][col] == val){
                return;
            }
            matrix[row][col] = val;
            for(int i=row; i < matrix.length;i++) {
                for (int j=col; j< matrix[0].length;j++){
                    int top = (i-1 < 0) ? 0 : sum[i-1][j];
                    int left = (j-1 < 0) ? 0 : sum[i][j-1];
                    int topLeft = (i-1<0 || j -1 <0) ? 0 : sum[i-1][j-1];
                    sum[i][j] = top + left - topLeft+ matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int current = sum[row2][col2];
            int left = (col1 - 1 < 0) ? 0 :  sum[row2][col1- 1];
            int top = (row1 -1 < 0) ? 0 : sum[row1 - 1][col2];
            int topLeft = (row1 - 1 < 0 || col1 -1 < 0) ? 0 : sum[row1 - 1][col1 -1];
            return current - left - top + topLeft;
        }
    }
}
