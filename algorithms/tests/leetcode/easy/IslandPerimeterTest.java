package leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class IslandPerimeterTest {

	@Test
	public void test() {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		assertEquals(16, IslandPerimeter.islandPerimeter(grid));
	}

}
