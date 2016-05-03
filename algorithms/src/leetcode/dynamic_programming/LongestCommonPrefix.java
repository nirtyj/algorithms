package leetcode.dynamic_programming;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		String smallest = null;
		int minSize = Integer.MAX_VALUE;
		for (String str : strs) {
			if (str.length() < minSize) {
				minSize = str.length();
				smallest = str;
			}
		}

		boolean mismatch = false;
		int i;
		for (i = 0; i < smallest.length(); i++) {
			for (String str : strs) {
				if (str.charAt(i) != smallest.charAt(i)) {
					mismatch = true;
					break;
				}
			}

			if (mismatch)
				break;
		}

		return smallest.substring(0, i);
	}
}
