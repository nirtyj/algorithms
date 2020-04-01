package com.leetcode.two_pointers;

/**
 * 11. https://leetcode.com/problems/container-with-most-water/description/
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater_11 {

    /**
     * Leetcode verified
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            // min height (breadth) * length
            int currArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
