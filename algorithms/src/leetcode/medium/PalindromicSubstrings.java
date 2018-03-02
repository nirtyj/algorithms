package leetcode.medium;
/**
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
public class PalindromicSubstrings {

	int count = 0;
    /**
     * Leetcode verified - Fastest
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
    
	/**
	 * Leetcode verified! - DP solution
	 * @param s
	 * @return
	 */
	public static int countSubstrings2(String s) {
		if (s == null || s.isEmpty())
			return 0;
		else if (s.length() == 1)
			return 1;

		boolean[][] matrix = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++)
			for (int j = 0; j < s.length(); j++)
				matrix[i][j] = true;

		int startEnd = s.length() - 1;
		int endStart = 0;
		int start = 0;
		int result = 0;
		while (startEnd >= 0) {
			start = 0;
			int end = endStart;
			while (start <= s.length() - 1 && end <= s.length() - 1) {
				boolean isPalindrome = (s.charAt(start) == s.charAt(end));
				boolean diagonalVal = (end - 1 < 0) || (start + 1 > s.length() - 1) ? true : matrix[start + 1][end - 1];
				int val = (isPalindrome == true) ? 1 : 0;
				matrix[start][end] = isPalindrome && diagonalVal;
				if (matrix[start][end] == true)
					result = result + val;
				start++;
				end++;

			}
			startEnd--;
			endStart++;
		}
		return result;
	}

	/**
	 * Leetcode verified - But slow!!
	 * 
	 * @param s
	 * @return
	 */
	public static int countSubstrings(String s) {
		if (s == null || s.isEmpty())
			return 0;
		else if (s.length() == 1)
			return 1;
		int startEnd = s.length() - 1;
		int endStart = 0;
		int start = 0;
		int result = 0;
		while (startEnd >= 0) {
			start = 0;
			int end = endStart;
			while (start <= s.length() - 1 && end <= s.length() - 1) {
				boolean isPalindrome = isPalindrome(s.substring(start, end + 1));
				int val = (isPalindrome == true) ? 1 : 0;
				result = result + val;
				start++;
				end++;
			}
			startEnd--;
			endStart++;
		}
		return result;
	}

	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
