package com.leetcode;

import com.leetcode.graph.unionfind.FriendCircles_547;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FriendCirclesTest {

    @Test
    public void test() {
        int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        assertEquals(2, FriendCircles_547.findCircleNum(input));
    }

}
