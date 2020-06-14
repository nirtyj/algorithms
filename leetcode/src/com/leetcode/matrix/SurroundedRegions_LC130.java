package com.leetcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not
 * flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will
 * be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions_LC130 {

    static int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    /**
     * Visit from edges to inside marking to not be changed. then go inside with any '0' and mark it to 'X' and change
     * the remaining back to 'O'
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length < 3 || board[0].length < 3){
            return;
        }
        // visit and traverse only if its on the edge
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    visitBFS(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'B')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    void visitBFS(char[][] board, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        board[i][j] = 'B';
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] direction : directions) {
                int x = direction[0] + point[0];
                int y = direction[1] + point[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                    board[x][y] = 'B';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    public static void main(String[] args){
        SurroundedRegions_LC130 s = new SurroundedRegions_LC130();
        char[][] arr = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        s.solve(arr);
    }
}
