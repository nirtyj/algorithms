package com.leetcode.random;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and
 * uniformily picks an integer point in the space covered by the rectangles.
 *
 * Note:
 *
 * An integer point is a point that has integer coordinates.
 * A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner,
 * and [x2, y2] are the integer coordinates of the top-right corner.
 * length and width of each rectangle does not exceed 2000.
 * 1 <= rects.length <= 100
 * pick return a point as an array of integer coordinates [p_x, p_y]
 * pick is called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * Example 2:
 *
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 */
public class RandomPointInNonOverlappingRectangles_LC497 {

    int[] arr;
    int allArea;
    Random r = new Random();
    int[][] rectangles;

    public RandomPointInNonOverlappingRectangles_LC497(int[][] rects) {
        rectangles = rects;
        arr = new int[rects.length];
        allArea = 0;
        for (int i = 0; i < rects.length; i++) {
            int x1 = rects[i][0];
            int y1 = rects[i][1];
            int x2 = rects[i][2];
            int y2 = rects[i][3];
            int area = (x2 - x1 + 1) * (y2 - y1 + 1);
            arr[i] = allArea + area;
            allArea = arr[i];
        }
    }


    public int[] pick() {
        int ar = r.nextInt(allArea + 1);
        int index = Arrays.binarySearch(arr, ar);
        if (index < 0) {
            index = -index - 1;
        }
        return findPoint(rectangles[index]);
    }

    int[] findPoint(int[] rect) {
        int x1 = rect[0];
        int y1 = rect[1];
        int x2 = rect[2];
        int y2 = rect[3];
        return IntStream.of(r.nextInt(x2 - x1 + 1) + x1, r.nextInt(y2 - y1 + 1) + y1).toArray();
    }
}
