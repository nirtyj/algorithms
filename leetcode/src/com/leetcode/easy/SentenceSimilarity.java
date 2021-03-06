package com.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 * <p>
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * <p>
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * <p>
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * <p>
 * Note:
 * <p>
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarity {

    /**
     * Leetcode verified
     *
     * @param words1
     * @param words2
     * @param pairs
     * @return
     */
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

        if ((words1 != null && words2 == null) || (words1 == null && words2 != null) || words1.length != words2.length)
            return false;

        HashMap<String, Set<String>> map = new HashMap<>();
        if (pairs != null && pairs.length != 0) {
            for (int i = 0; i < pairs.length; i++) {
                String w1 = pairs[i][0];
                String w2 = pairs[i][1];
                Set<String> val1 = map.getOrDefault(w1, new HashSet<>());
                val1.add(w2);
                map.put(w1, val1);

                Set<String> val2 = map.getOrDefault(w2, new HashSet<>());
                val2.add(w1);
                map.put(w2, val2);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2))
                continue;

            if (!(map.getOrDefault(word1, Collections.emptySet()).contains(word2)
                    || map.getOrDefault(word2, Collections.emptySet()).contains(word1))) {
                return false;
            }
        }
        return true;
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {

        if (words1.length != words2.length) return false;

        Set<String> pairset = new HashSet();
        for (List<String> pair: pairs)
            pairset.add(pair.get(0) + "#" + pair.get(1));

        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                    !pairset.contains(words1[i] + "#" + words2[i]) &&
                    !pairset.contains(words2[i] + "#" + words1[i]))
                return false;
        }
        return true;
    }
}
