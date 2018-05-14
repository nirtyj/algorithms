package com.interviewbit.greedy;

import java.util.ArrayList;

/**
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Sample Input :

Ratings : [1 2]
Sample Output :

3
The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. 
So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
*/
public class DistributeCandies {

	/**
	 * Verified by interview bit
	 * @param A
	 * @return
	 */
	public int candy(ArrayList<Integer> A) {
		if (A == null || A.size() == 0)
			return 0;
		if (A.size() == 1)
			return 1;

		int[] mem = new int[A.size()];
		mem[0] = 1;
		for (int i = 1; i < A.size(); i++) {
			if (mem[i] == 0)
				mem[i] = 1;

			if (A.get(i) > A.get(i - 1))
				mem[i] = mem[i - 1] + 1;
		}

		for (int i = A.size() - 1; i > 0; i--) {
			if (mem[i - 1] <= mem[i] && A.get(i - 1) > A.get(i)) {
				mem[i - 1] = mem[i] + 1;
			}
		}

		int sum = 0;
		for (int i = 0; i < mem.length; i++) {
			sum = sum + mem[i];
		}

		return sum;
	}
}
