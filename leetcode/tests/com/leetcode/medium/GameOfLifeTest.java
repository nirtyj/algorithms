package com.leetcode.medium;

import com.leetcode.matrix.GameOfLife;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void test() {
        int[][] board = {{1, 1}, {1, 0}};
        GameOfLife life = new GameOfLife();
        life.gameOfLife(board);
        System.out.println();
    }

}
