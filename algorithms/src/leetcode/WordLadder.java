package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Breadth first search. optimal - Leetcode verified
 * 
 * @author njaganathan
 */
public class WordLadder {

	private static class WordNode {
		String word;
		int noOfSteps;

		public WordNode(String word, int noOfSteps) {
			this.word = word;
			this.noOfSteps = noOfSteps;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 2;
			result = prime * result + ((word == null) ? 0 : word.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordNode other = (WordNode) obj;
			if (word == null) {
				if (other.word != null)
					return false;
			} else if (!word.equals(other.word))
				return false;
			return true;
		}

	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordDict = new HashSet<>(wordList);

		if (beginWord.equals(endWord))
			return 0;

		LinkedList<WordNode> result = new LinkedList<WordNode>();
		result.add(new WordNode(beginWord, 1));

		Map<Integer, HashSet<Character>> characterMap = new HashMap<>();
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				HashSet<Character> chars = characterMap.get(i);
				if (chars == null) {
					chars = new HashSet<Character>();
					characterMap.put(i, chars);
				}
				chars.add(word.charAt(i));
			}
		}
		while (!result.isEmpty()) {
			WordNode top = result.remove();
			if (top.word.equals(endWord)) {
				return top.noOfSteps;
			}

			char[] arr = top.word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				HashSet<Character> chars = characterMap.get(i);
				for (char c : chars) {
					char temp = arr[i];
					arr[i] = c;
					String newWord = new String(arr);
					if (!newWord.equals(top.word) && wordDict.contains(newWord)) {
						result.add(new WordNode(newWord, top.noOfSteps + 1));
						wordDict.remove(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return 0;
	}

}
