package com.leetcode.hard;

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/
public class JumpGame2 {

	/**
	 * Leetcode verified
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
		if (A.length <= 1)
			return 0;

		int maxReach = 0;
		int lastMaxReach = 0;
		int steps = 0;
		/**
		 * i <= max handles the case where there is no reach to the end.
		 */
		for (int i = 0; i <= maxReach && i < A.length; i++) {

			// when current jump is more than last max, increase a step
			// increases one step later after max is calculated
			if (lastMaxReach < i) {
				steps++;
				lastMaxReach = maxReach;
			}

			int reachFromHere = i + A[i];
			maxReach = Math.max(maxReach, reachFromHere);
		}

		/**
		 * if max has not reached the end, return 0
		 */
		if (maxReach < A.length - 1)
			return 0;

		return steps;

	}
}
