package com.leetcode.easy;

/**
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
and B is not a substring of A repeated two times ("abcdabcd").

*/
public class RepeatedStringMatch {

	/**
	 * Leetcode verified
	 * @param A
	 * @param B
	 * @return
	 */
	public static int repeatedStringMatch(String A, String B) {
		StringBuilder sb = new StringBuilder();
		sb.append(A);
		int count = 1;
		while (sb.indexOf(B) < 0) {
			if (sb.length() - A.length() > B.length()) {
				return -1;
			}
			sb.append(A);
			count++;
		}

		return count;
	}
}
