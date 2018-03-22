package careercup.facebook;

import java.util.HashMap;
import java.util.Map;

public class WordArraySortedAccordingToInputArray {
	public static boolean isOrdered(String[] words, char[] ordering) {
		if (words == null || ordering == null) {
			throw new IllegalArgumentException("Invalid input!");
		}
		Map<Integer, Character> ranking = new HashMap<>();
		for (int i = 0; i < ordering.length; i++) {
			ranking.put(i, ordering[i]);
		}

		int rank = 0;
		int charWordRank = 0;
		for (String word : words) {
			char c = ranking.get(rank);
			if (word.contains(c + "")) {
				if (rank < charWordRank) {
					return false;
				}
				rank++;
			}
			charWordRank++;
		}
		return true;
	}
}
