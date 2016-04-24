package epi.dynamic_programming;

import java.util.List;

public class MaxSubArraySum {

	public static int getMaxSum(List<Integer> array) 
	{
		int max = Integer.MIN_VALUE;
		int maxTillHere = 0;
		for (int num : array) {
			if (maxTillHere < 0 && maxTillHere < num) {
				maxTillHere = num;
			} else {
				maxTillHere += num;
			}
			max = Math.max(max, maxTillHere);
		}
		return max;
	}
}
