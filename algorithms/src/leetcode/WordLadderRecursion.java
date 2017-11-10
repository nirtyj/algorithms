package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * depth first search. not optimal
 * @author njaganathan
 */
public class WordLadderRecursion {

	private static int minSteps = Integer.MAX_VALUE;

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordDict = new HashSet<>(wordList);
		minSteps = Integer.MAX_VALUE;

		if (beginWord.equals(endWord))
			return Collections.emptyList();

		wordList.add(beginWord);
		wordList.add(endWord);
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

		LinkedList<String> list = new LinkedList<String>();
		list.add(beginWord);

		List<List<String>> result = new ArrayList<>();
		ladderInner(list, endWord, wordDict, characterMap, result);
		return result;
	}

	public static void ladderInner(LinkedList<String> list, String endWord, Set<String> wordDict,
			Map<Integer, HashSet<Character>> characterMap, List<List<String>> result) {
		String last = list.getLast();
		if (list.size() > minSteps) {
			return;
		}
		if (last.equals(endWord)) {
			if (list.size() <= minSteps) {
				if (list.size() < minSteps) {
					result.clear();
				}
				minSteps = list.size();
				result.add(new ArrayList<>(list));
			}
			return;
		}

		char[] arr = last.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			HashSet<Character> chars = characterMap.get(i);
			for (char c : chars) {
				char temp = arr[i];

				arr[i] = c;
				String newWord = new String(arr);
				if (!newWord.equals(last) && wordDict.contains(newWord)) {
					list.add(newWord);
					wordDict.remove(newWord);

					ladderInner(list, endWord, wordDict, characterMap, result);

					list.removeLast();
					wordDict.add(newWord);
				}

				arr[i] = temp;
			}
		}
	}
}
