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
public class WordLadderII {

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
				printLinkedList(result);
				minSteps = top.noOfSteps;
				ArrayList<String> results = new ArrayList<>();
				results.addAll(top.wordsVisited);
				results.add(top.word);
				finalllResult.add(results);
				System.out.println("<------");

				continue;
			}

			// to loop through all the nodes present in the queue
			if (top.noOfSteps + 1 > minSteps)
				continue;
			
			// we dont need to go further. we can break out.
			if (top.noOfSteps + 2 > minSteps)
				break;
			
			System.out.println("-------------------------");
			System.out.println("top - " + top.word + " at " + top.noOfSteps);

			char[] arr = top.word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				HashSet<Character> chars = characterMap.get(i);
				// or iterate from the available chars - a to z
				for (char c : chars) {
					
					// swap the characters to form a new word at each position
					char temp = arr[i];
					arr[i] = c;
					
					String newWord = new String(arr);
					if (
							// is not the same word
							!newWord.equals(top.word) 
							// if the word is valid
							&& wordDict.contains(newWord) 
							// if its not visited previously for this path
							&& !top.wordsVisited.contains(newWord)
							// if this node is not processed before
							&& !wordsSeen.contains(newWord)) 
					{
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

		return finalllResult;
	}

	public static void printLinkedList(LinkedList<WordNode> words) {
		System.out.println();
		for (WordNode word : words) {
			System.out.print(word.word + " : " + word.noOfSteps + " -> ");
		}
		System.out.println();

	}

}
