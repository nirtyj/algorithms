package epi.hashtables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntries {

	public static int findNearestRepeatedEntries(List<String> paragraph) {
		Map<String, Integer> lastSeenMap = new HashMap<String, Integer>();
		int nearestRepeatedEntry = Integer.MAX_VALUE;
		for (int i = 0; i < paragraph.size(); i++) {
			String word = paragraph.get(i);
			if (lastSeenMap.containsKey(word)) {
				int lastIndex = lastSeenMap.get(word);
				if (i - lastIndex < nearestRepeatedEntry)
					nearestRepeatedEntry = i - lastIndex;
			}
			lastSeenMap.put(word, i);
		}
		return nearestRepeatedEntry;
	}
}
