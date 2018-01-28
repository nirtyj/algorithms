package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Breadth first search. optimal - Not optimal enough -- 30/39 cases passed .
 * time limit exceeded
 * 
 * @author njaganathan
 *
 */
public class WordLadderIIBest {

	private static class WordNode {
		String word;
		int noOfSteps;
		WordNode pre;

		public WordNode(String word, int noOfSteps, WordNode pre) {
			this.word = word;
			this.noOfSteps = noOfSteps;
			this.pre = pre;
		}

		LinkedHashSet<String> wordsVisited = new LinkedHashSet<String>();
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		Set<String> wordDict = new HashSet<>(wordList);

		if (beginWord.equals(endWord))
			return Collections.emptyList();

		Map<Integer, HashSet<Character>> characterMap = new HashMap<>();
		wordList.add(beginWord);
		wordList.add(endWord);
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

		List<List<String>> finalllResult = new ArrayList<>();

		LinkedList<WordNode> result = new LinkedList<WordNode>();
		result.add(new WordNode(beginWord, 1, null));
		HashSet<String> wordsSeen = new HashSet<String>();
		int minSteps = Integer.MAX_VALUE;

		while (!result.isEmpty()) {
			
			WordNode top = result.remove();
			wordsSeen.add(top.word);
			
			if (top.word.equals(endWord) && top.noOfSteps <= minSteps) {
				WordLadderIIBest.minSteps = top.noOfSteps;
				break;
			}

			if (top.noOfSteps + 1 > minSteps)
				continue;
			
			if (top.noOfSteps + 2 > minSteps)
				break;
			
			System.out.println("-------------------------");
			System.out.println("top - " + top.word + " at " + top.noOfSteps);

			char[] arr = top.word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				HashSet<Character> chars = characterMap.get(i);
				// or iterate from the available chars - a to z
				for (char c : chars) {
					char temp = arr[i];
					arr[i] = c;
					String newWord = new String(arr);
					if (!newWord.equals(top.word) && wordDict.contains(newWord) && !top.wordsVisited.contains(newWord)
							&& !wordsSeen.contains(newWord)) {
						WordNode node = new WordNode(newWord, top.noOfSteps + 1, top);
						node.wordsVisited.addAll(top.wordsVisited);
						node.wordsVisited.add(top.word);
						result.add(node);
						System.out.println(" adding - " + newWord);
					}

					arr[i] = temp;
				}
			}

		}

		WordLadderIIBest.minSteps = minSteps;
		LinkedList<String> list = new LinkedList<String>();
		list.add(beginWord);

		List<List<String>> resultss = new ArrayList<>();
		ladderInner(list, endWord, wordDict, characterMap, resultss);
		
		return resultss;
	}
	private static int minSteps = Integer.MAX_VALUE;

	public static void ladderInner(LinkedList<String> list, String endWord, Set<String> wordDict,
			Map<Integer, HashSet<Character>> characterMap, List<List<String>> result) {
		String last = list.getLast();
		if (list.size()  > minSteps) {
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
	public static void printLinkedList(LinkedList<WordNode> words) {
		System.out.println();
		for (WordNode word : words) {
			System.out.print(word.word + " : " + word.noOfSteps + " -> ");
		}
		System.out.println();

	}

}
