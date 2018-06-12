package com.leetcode.medium;

/**
5. https://leetcode.com/problems/longest-palindromic-substring/description/
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 
Example:
Input: "cbbd"
Output: "bb"
*/	
public class LongestPalindromicSubstring_5 {

	private int lo, maxLen;

	/**
	 * Leetcode verified
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
		// go untill len -1 as we do i+1
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		if (maxLen < end - begin - 1) {
			lo = begin + 1; // + 1 because, the loop ends with extra increment which is invalid
			maxLen = end - begin - 1; // -1 beacause of the same reason
		}
	}
}
