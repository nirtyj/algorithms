package epi.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarrayDistinctEnties {

	public static int findLongestSubarrayDistinctEnties(List<Character> paragraph) {
		Map<Character, Integer> lastSeenIndexMap = new HashMap<Character, Integer>();
		int leftIndex = 0;
		int rightIndex = 1;
		int longestSubArray = 0;
		lastSeenIndexMap.put(paragraph.get(leftIndex), leftIndex);
		while (leftIndex < paragraph.size() && rightIndex < paragraph.size()) {
			longestSubArray = Math.max(longestSubArray, rightIndex - leftIndex);
			Character key = paragraph.get(rightIndex);
			if (lastSeenIndexMap.containsKey(key)) {
				leftIndex = lastSeenIndexMap.get(key) + 1;
			}
			lastSeenIndexMap.put(key, rightIndex);
			rightIndex++;
		}
		return longestSubArray;
	}
}
