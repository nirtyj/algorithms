package com.leetcode.disjointsets;

import java.util.HashMap;

/**
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/
public class SentenceSimilarityII {

	/**
	 * leetcode verified
	 * @param words1
	 * @param words2
	 * @param pairs
	 * @return
	 */
	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if ((words1 != null && words2 == null) || (words1 == null && words2 != null) || words1.length != words2.length)
			return false;

		HashMap<String, String> idMappingToParent = new HashMap<String, String>();
		for (int i = 0; i < pairs.length; i++) {
			// put key and parent as itself when we see a new word
			if (!idMappingToParent.containsKey(pairs[i][0]))
				idMappingToParent.put(pairs[i][0], pairs[i][0]);
			if (!idMappingToParent.containsKey(pairs[i][1]))
				idMappingToParent.put(pairs[i][1], pairs[i][1]);

			String keyParent = findParent(pairs[i][0], idMappingToParent);
			String valueParent = findParent(pairs[i][1], idMappingToParent);
			// if its already connected continue
			if (keyParent == valueParent)
				continue;
			// union
			idMappingToParent.put(keyParent, valueParent);
		}

		for (int i = 0; i < words1.length; i++) {
			String word1 = words1[i];
			String word2 = words2[i];
			if (word1.equals(word2))
				continue;
			// find if both word has same parent
			if (!findParent(word1, idMappingToParent).equals(findParent(word2, idMappingToParent)))
				return false;
		}
		return true;
	}

	private static String findParent(String word, HashMap<String, String> map) {
		if (!map.containsKey(word))
			return word;

		while (word != map.get(word))
			word = map.get(word);
		return word;
	}
}
