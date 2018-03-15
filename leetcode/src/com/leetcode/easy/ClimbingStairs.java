package com.leetcode.easy;

/**
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.

Example 1:
Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
public class ClimbingStairs {

	/**
	 * Leetcode verified - fibonacci
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 0 || n == 1)
			return 1;
		else if (n == 2)
			return 2;

		int val = 0;
		int valnminus1 = 2;
		int valnminus2 = 1;
		for (int i = 3; i <= n; i++) {
			val = valnminus1 + valnminus2;
			valnminus2 = valnminus1;
			valnminus1 = val;
		}
		return val;
	}
	
	/**
	 * Time limit exceeded
	 * @param n
	 * @return
	 */
	public int climbStairsR(int n) {
		if (n == 0 || n == 1)
			return 1;
		else if (n == 2)
			return 2;
		return climbStairsR(n - 1) + climbStairsR(n - 2);
	}
}
