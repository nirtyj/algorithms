package leetcode.dynamic_programming;

public class LongestPalindromicSubstring {

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
		//		0,2	1,3	2,4	3,5	4,6
		//		0,3	1,4	2,5	3,6	
		//		0,4	1,5	2,6		
		//		0,5	1,6			
		//		0,6				

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

	public static String longestPalindromeFaster(String s) {

		if (s.isEmpty()) {
			return null;
		}

		if (s.length() == 1) {
			return s;
		}

		String longest = s.substring(0, 1);

		for (int i = 0; i < s.length(); i++) {
			String palindrome1 = palindromHelper(s, i, i);
			String palindrome2 = palindromHelper(s, i, i + 1);
			if (palindrome1.length() > longest.length()) {
				longest = palindrome1;
			}
			if (palindrome2.length() > longest.length()) {
				longest = palindrome2;
			}
		}
		return s;
	}

	private static String palindromHelper(String s, int begin, int end) {
		while (begin >= 0 && end < s.length()) {
			if (s.charAt(begin) == s.charAt(end)) {
				begin--;
				end++;
			}
		}
		return s.substring(begin + 1, end);

	}
}
