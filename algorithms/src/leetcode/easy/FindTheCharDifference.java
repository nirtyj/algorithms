package leetcode.easy;

import java.util.Arrays;

/**
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/
public class FindTheCharDifference {

	/**
	 * Leetcode verified
	 * @param s
	 * @param t
	 * @return
	 */
	public char findTheDifference(String s, String t) {
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		Arrays.sort(sarr);
		Arrays.sort(tarr);
		int i = 0;
		for (; i < sarr.length; i++) {
			if (sarr[i] == tarr[i])
				continue;
			else
				return tarr[i];
		}
		return tarr[i];
	}
}