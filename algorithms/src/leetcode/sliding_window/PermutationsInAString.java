package leetcode.sliding_window;

/**
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True

Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/
public class PermutationsInAString {

	public boolean checkInclusionPseudoCode(String s1, String s2) {
		/** Python logic
		"""
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        start = end = 0
        memo = collections.defaultdict(int)
        for s in s1:
            memo[s] += 1
        counter = len(memo)
        while end < len(s2):
            c = s2[end]
            if c in memo:
                memo[c] -= 1
                if memo[c] == 0:
                    counter -= 1
            end += 1
            while counter == 0:
                t = s2[start]
                if t in memo:
                    memo[t] += 1
                    if memo[t] >0 :
                        counter += 1
                if end - start == len(s1):
                    return True
                start += 1
        return False
        */
		return false;
	}
}
