package epi.hashtables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestRange {
	
	public static int findLongestContainedRange(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>(list);
		int longestRange = 0;
		while (!set.isEmpty()) {
			int processingInteger = set.iterator().next();
			int upperBound = processingInteger + 1;
			while (set.contains(upperBound)) {
				set.remove(upperBound);
				upperBound++;
			}

			int lowerBound = processingInteger - 1;
			while (set.contains(lowerBound)) {
				set.remove(lowerBound);
				lowerBound--;
			}
			set.remove(processingInteger);
			longestRange = Math.max(longestRange, upperBound - lowerBound - 1);
		}
		return longestRange;
	}
}
