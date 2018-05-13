package com.interviewbit.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
https://www.interviewbit.com/problems/longest-arithmetic-progression/

Find longest Arithmetic Progression in an integer array and return its length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression. Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
Examples
1) 1, 2, 3(All differences are equal to 1)
2) 7, 7, 7(All differences are equal to 0)
3) 8, 5, 2(Yes, difference can be negative too)

Samples
1) Input: 3, 6, 9, 12
Output: 4

2) Input: 9, 4, 7, 2, 10
Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))
*/
public class LengthOfLongestArithmeticProgression {

	/**
	 * Verified by interviewbit
	 * @param A
	 * @return
	 */
	public int solve(final List<Integer> A) {
		Map<Integer, Integer> mapFrequency = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			HashSet<Integer> present = new HashSet<>();
			for (int j = i + 1; j < A.size(); j++) {
				present.add(Math.abs(A.get(i) - A.get(j)));
			}
			for (Integer intval : present) {
				int val = mapFrequency.getOrDefault(intval, 0);
				val = val + 1;
				mapFrequency.put(intval, val);
				max = Math.max(max, val);
			}
		}
		return max + 1;
	}
}
