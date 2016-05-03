package leetcode.dynamic_programming;

public class LongestCommonSubsequence {

	/**
	 * http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-subsequence/
	 * http://bix.ucsd.edu/bioalgorithms/downloads/code/LCS.java
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getLongestCommonSubsequence(String s1, String s2) {

		int[][] m = new int[s1.length() + 1][s2.length() + 1];

		int i, j;
		for (i = 0; i < s1.length() + 1; i++)
			m[i][0] = 0;
		for (j = 0; j < s2.length() + 1; j++)
			m[0][j] = 0;

		for (i = 0; i < s1.length(); i++) {
			for (j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					m[i + 1][j + 1] = m[i][j] + 1;
				} else {
					m[i + 1][j + 1] = Math.max(m[i][j + 1], m[i + 1][j]);
				}
			}
		}

		return getLCSString(m, s1, s1.length(), s2.length());
	}

	private static String getLCSString(int[][] m, String s1, int i, int j) {

		if (i == 0 || j == 0)
			return "";

		String s = "";

		if (m[i][j] > m[i - 1][j - 1] && m[i][j] > m[i - 1][j] && m[i][j] > m[i][j - 1]) {
			s = getLCSString(m, s1, i - 1, j - 1);
			s = s + s1.substring(i - 1, i);
		} else if (m[i][j] == m[i - 1][j]) {
			s = getLCSString(m, s1, i - 1, j);
		} else {
			s = getLCSString(m, s1, i, j - 1);
		}
		return s;
	}


	static int max = 0;
	static String ans = "";
	static int[][] matrix;

	public static String getLongestCommonSubsequenceMemoization(String s1, String s2) {
		max = 0;
		ans = "";
		matrix = new int[s1.length() + 1][s2.length() + 1];
		getLongestCommonSubsequenceMemoizationHelper(s1, s1.length(), s2, s2.length(), 0, "");
		return ans;
	}

	private static int getLongestCommonSubsequenceMemoizationHelper(String s1, int i, String s2, int j, int n,
			String s) {

		if (i == 0 || j == 0) {
			// Remember the best answer at the end of the loop
			if (n >= max) {
				max = n;
				ans = s;
				System.out.println(ans);
			}
			return 0;
		}

		if (matrix[i][j] > 0) {
			return matrix[i][j];
		}

		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			int val = getLongestCommonSubsequenceMemoizationHelper(s1, i - 1, s2, j - 1, n + 1, s1.charAt(i - 1) + s);
			matrix[i][j] = val + 1;
			return matrix[i][j];
		} else {
			int val1 = getLongestCommonSubsequenceMemoizationHelper(s1, i - 1, s2, j, n, s);
			int val2 = getLongestCommonSubsequenceMemoizationHelper(s1, i, s2, j - 1, n, s);
			matrix[i][j] = Math.max(val1, val2);
			return matrix[i][j];
		}
	}

	public static String getLongestCommonSubsequenceRecursive(String s1, String s2) {
		max = 0;
		ans = "";
		longestCommonSubsequenceRecursiveHelper(s1, s2, 0, "");
		return ans;
	}

	public static int longestCommonSubsequenceRecursiveHelper(String s1, String s2, int n, String s)
	{
		if(s1.equals("") || s2.equals(""))
		{
			// Remember the best answer at the end of the loop
			 if ( n >= max )
			 {
			    max = n;
			    ans = s;
			 }
			return 0;
		}
		
		if(s1.charAt(s1.length() -1) == s2.charAt(s2.length()-1))
		{
			return 1 + longestCommonSubsequenceRecursiveHelper(s1.substring(0, s1.length()-1),  s2.substring(0, s2.length()-1), n+1, s1.charAt(s1.length()-1) + s);
		}
		else
		{
			return Math.max(
					longestCommonSubsequenceRecursiveHelper(s1.substring(0, s1.length()-1),  s2, n, s), 
					longestCommonSubsequenceRecursiveHelper(s1,  s2.substring(0, s2.length()-1), n, s)
							);
		}
	}
	
}
