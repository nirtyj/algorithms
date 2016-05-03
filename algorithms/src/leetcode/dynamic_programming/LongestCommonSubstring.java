package leetcode.dynamic_programming;

public class LongestCommonSubstring {

	public static String getLongestCommonSubstring(String s1, String s2) {
		String small = s1;
		String large = s2;
		if (s1.length() > s2.length()) {
			large = s1;
			small = s2;
		}
		int[][] matrix = new int[small.length()][large.length()];

		int posInSmall = -1;
		int max_count = 0;

		for (int i = 0; i < small.length(); i++) {
			for (int j = 0; j < large.length(); j++) {
				if (small.charAt(i) == large.charAt(j)) {
					if (i - 1 >= 0 && j - 1 >= 0)
						matrix[i][j] = 1 + matrix[i - 1][j - 1];
					else
						matrix[i][j] = 1;

					if (matrix[i][j] > max_count) {
						max_count = matrix[i][j];
						posInSmall = i;
					}
				}
			}
		}

		if (posInSmall == -1)
			return "";
		else
			return small.substring(posInSmall - max_count + 1, posInSmall + 1);

	}
	
	public static String getLongestCommonSubstringNaive(String s1, String s2) {
		String small = s1;
		String large = s2;
		if (s1.length() > s2.length()) {
			large = s1;
			small = s2;
		}
		
		String longest = "";
		int i = large.length() - 1;
		while (i >= 0) {
			int j = small.length() - 1;
			int restorei = i;
			while (j >= 0 && i >= 0) {
				if (large.charAt(i) == small.charAt(j)) {
					int start = j;

					int moved = 0;
					while (i >= 0 && j >= 0 && large.charAt(i) == small.charAt(j)) {
						i--;
						j--;
						moved++;
					}

					if (moved >= longest.length()) {
						longest = small.substring(start - moved + 1, start + 1);
					}
				} else {
					j--;
				}
			}
			i = --restorei;
		}
		return longest;
	}
}
