package com.leetcode.hard;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {

    /**
     * Leetcode verified
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        // less than or 2 points
        if (points.length <= 0)
            return 0;
        if (points.length <= 2)
            return points.length;
        int result = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<BigDecimal, Integer> hm = new HashMap<BigDecimal, Integer>();
            int samex = 1;
            int samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if (points[j].x == points[i].x) {
                        samex++;
                        if (points[j].y == points[i].y)
                            samep++;
                        continue;
                    }

                    // find the slope and update
                    BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
                    BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
                    // if dx is 0, slope is not calculated properly. hence calculate samex's separately
                    BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);

                    if (hm.containsKey(k)) {
                        hm.put(k, hm.get(k) + 1);
                    } else {
                        hm.put(k, 2);
                    }

                    // smax of slope + same point
                    result = Math.max(result, hm.get(k) + samep);
                }
            }

            // max of same x's or slopes
            result = Math.max(result, samex);
        }
        return result;
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
