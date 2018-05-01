package interviewchallenges;

import java.util.*;

public class AmazonII {

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		if (literatureText == null || literatureText.isEmpty())
			return Collections.emptyList();

		// WRITE YOUR CODE HERE
		HashMap<String, Integer> hitCounter = new HashMap<>();
		Integer maxHit = -1;
		HashSet<String> excludedWords = new HashSet<>(wordsToExclude);

		String[] words = literatureText.trim().split("\\s+");
		if (words != null) {
			// process all the words
			for (String word : words) {
				// if the word is supposed to be excluded, continue to next word
				if (excludedWords.contains(word))
					continue;

				int hit = hitCounter.getOrDefault(word, 0);
				hit = hit + 1;
				hitCounter.put(word, hit);
				maxHit = Math.max(maxHit, hit);
			}

			// go through all the words and create a return list
			List<String> result = new ArrayList<>();
			for (Map.Entry<String, Integer> entry : hitCounter.entrySet()) {
				if (entry.getValue() == maxHit) {
					result.add(entry.getKey());
				}
			}
			return result;
		}
		return Collections.emptyList();

	}
	// METHOD SIGNATURE ENDS

	class LogEntry implements Comparable<LogEntry> {
		String entry;
		String key;
		String words;
		boolean isNumber;

		LogEntry(String entry) {
			this.entry = entry;
			String[] tokens = entry.trim().split("\\s+", 2);
			this.key = tokens[0];
			this.words = tokens[1];
			try {
				Integer.parseInt(this.words.split("\\s+", 2)[0]);
				isNumber = true;
			} catch (Exception e) {
				isNumber = false;
			}
		}

		public String getEntry() {
			return this.entry;
		}

		@Override
		public int compareTo(LogEntry o) {
			// if both entries are alphabetic, return sorted first word first
			if (this.isNumber == false && o.isNumber == false) {
				int wordsCompare = this.words.compareTo(o.words);
				if (wordsCompare == 0)
					// if words are same compare the keys - TODO implement ASCII sort comparator
					// to sort the keys
					return this.key.compareTo(o.key);
				else
					return wordsCompare;
			}
			// if this is number, and other not a number return not a number first
			else if (this.isNumber == true && o.isNumber == false) {
				return +1;
			}
			// if this is Not a number, and other is a number return not a number first
			else if (this.isNumber == false && o.isNumber == true) {
				return -1;
			} else // this.isNumber == true && o.isNumber == true
			{
				// if both are number, return first inserted first
				return +1;
			}
		}
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> reorderLines(int logFileSize, List<String> logfile) {
		// WRITE YOUR CODE HERE
		TreeSet<LogEntry> sortedSet = new TreeSet<>();
		for (int i = 0; i < logFileSize; i++) {
			LogEntry e = new LogEntry(logfile.get(i));
			sortedSet.add(e);
		}
		ArrayList<String> result = new ArrayList<>();
		sortedSet.forEach(s -> result.add(s.getEntry()));
		return result;
	}
	// METHOD SIGNATURE ENDS
	
	
	/**
	 *  Recent Questions:
	 *  2D Matrix, Roman number conversions, System design and merging k sorted lists.
	 *  LRU cache, overlapping rectangles  , Longest palindrome  
	 */
}
