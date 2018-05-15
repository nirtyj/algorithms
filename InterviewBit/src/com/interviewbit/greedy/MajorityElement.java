package com.interviewbit.greedy;

import java.util.List;

/**
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :
Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
*/
public class MajorityElement {

	/**
	 * verified by interview bit
	 * @param A
	 * @return
	 */
	public int majorityElement(final List<Integer> A) {
		if (A == null || A.size() == 0)
			return 0;
		else if (A.size() == 1)
			return A.get(0);

		int num = A.get(0);
		int count = 1;
		for (int i = 1; i < A.size(); i++) {
			if (num == A.get(i))
				count++;
			else
				count--;

			if (count <= 0) {
				num = A.get(i);
				count = 1;
			}
		}
		return num;
	}
}
