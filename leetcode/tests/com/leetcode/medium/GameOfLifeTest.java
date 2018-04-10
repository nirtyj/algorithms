package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.matrix.GameOfLife;

public class GameOfLifeTest {

	@Test
	public void test() {
		int[][] board = {{1,1},{1,0}};
		GameOfLife life = new GameOfLife();
		life.gameOfLife(board);
		System.out.println();
	}

}
