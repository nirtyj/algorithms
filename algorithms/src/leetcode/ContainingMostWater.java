package leetcode;

import java.util.List;

public class ContainingMostWater {

	public static int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
	 
		int max = 0;
		int left = 0;
		int right = height.length - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
	 
		return max;
	}
	
	public static int maxArea(List<Integer> heights) {
		int res = 0;
		for (int i = 0; i < heights.size(); ++i) {
			for (int j = i + 1; j < heights.size(); ++j) {
				res = Math.max(res, Math.min(heights.get(i), heights.get(j)) * (j - i));
			}
		}
		return res;
	}

}
