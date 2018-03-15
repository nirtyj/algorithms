package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.IslandPerimeter;

public class IslandPerimeterTest {

	@Test
	public void test() {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		assertEquals(16, IslandPerimeter.islandPerimeter(grid));
	}

}
