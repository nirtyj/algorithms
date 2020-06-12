package com.leetcode;

import com.leetcode.graph.topologicalsort.CourseScheduleII_LC210;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CourseScheduleIITest {

    @Test
    public void testMethod() {
        CourseScheduleII_LC210 cs = new CourseScheduleII_LC210();
        int[][] input = {{0, 1}, {1, 0}};
        int[] result = cs.findOrder(2, input);
        assertEquals(0, result.length);
    }
}
