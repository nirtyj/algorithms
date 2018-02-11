package leetcode.medium;

/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 
Example:
Input: "cbbd"
Output: "bb"
*/	
public class LongestPalindromicSubstring {

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
	
	// Dynamic programming - Does not work - wrong answer
	public static String longestPalindrome2(String s) {

		if (s == null)
			return null;

		if (s.length() <= 1)
			return s;

		int palindromeBeginsAt = 0;
		int maxLength = 1;

		int[][] matrix = new int[s.length()][s.length()];

		int length = s.length();

		for (int i = 0; i < length; i++)
			matrix[i][i] = 1;

		for (int i = 0; i < length - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				matrix[i][i + 1] = 1;
				maxLength = 2;
			}
		}

		// loop sequence below
		// 0,2 1,3 2,4 3,5 4,6
		// 0,3 1,4 2,5 3,6
		// 0,4 1,5 2,6
		// 0,5 1,6
		// 0,6

		int startingj = 2;
		int j = startingj;
		while (j < length) {
			int i = 0;
			while (i < length - 1 && j < length) {
				if (s.charAt(i) == s.charAt(j)) {

					// copy the previous diagonal value.
					matrix[i][j] = matrix[i + 1][j - 1];

					// check if its true
					if (matrix[i][j] == 1) {
						palindromeBeginsAt = i;
						maxLength = j - i + 1;
					}
				} else {
					matrix[i][j] = 0;
				}
				i++;
				j++;
			}
			startingj++;
			j = startingj;
		}

		return s.substring(palindromeBeginsAt, maxLength + palindromeBeginsAt);
	}

}
