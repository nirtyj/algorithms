package com.leetcode;

import com.leetcode.easy.IslandPerimeter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandPerimeterTest {

    @Test
    public void test() {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        assertEquals(16, IslandPerimeter.islandPerimeter(grid));
    }

}
