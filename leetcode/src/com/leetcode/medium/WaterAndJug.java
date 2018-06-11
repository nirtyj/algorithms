package com.leetcode.medium;

/**
You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs completely with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False
*/
public class WaterAndJug {

	/**
	 * Leetcode verified
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean canMeasureWater(int x, int y, int z) {
		// limit brought by the statement that water is finallly in one or both buckets
		if (x + y < z)
			return false;
		// case x or y is zero
		if (x == z || y == z || x + y == z)
			return true;

		// get GCD, then we can use the property of Bézout's identity
		return z % findGCD(x, y) == 0;
	}

	private static int findGCD(int number1, int number2) {
		// base case
		if (number2 == 0) {
			return number1;
		}
		return findGCD(number2, number1 % number2);
	}
}
