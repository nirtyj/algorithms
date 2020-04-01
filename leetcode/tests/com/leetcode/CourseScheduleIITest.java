package com.leetcode;

import com.leetcode.graph.topologicalsort.CourseScheduleII;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseScheduleIITest {

    @Test
    public void testMethod() {
        CourseScheduleII cs = new CourseScheduleII();
        int[][] input = {{0, 1}, {1, 0}};
        int[] result = cs.findOrder(2, input);
        assertEquals(0, result.length);
    }
}
