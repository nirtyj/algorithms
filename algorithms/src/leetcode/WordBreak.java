package leetcode;

import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.isEmpty())
			return false;

		// one more than the actual size of string
		boolean[] containsArray = new boolean[s.length() + 1];
		containsArray[0] = true;
		// this is upto the length of the string
		for (int i = 0; i < s.length(); i++) {
			if (containsArray[i] == true) {
				// this is less than equals to string length - needed for substring
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						containsArray[j] = true;
					}
				}
			}
		}

		return containsArray[s.length()];
	}
}
