package com.leetcode.graph.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 */
public class AlienDictionary_LC269 {

    /**
     * O(C) - total characters in the words
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        HashMap<Character, HashSet<Character>> indegree = new LinkedHashMap<>();
        // init
        for (String word : words) {
            for (int k = 0; k < word.length(); k++) {
                indegree.putIfAbsent(word.charAt(k), new LinkedHashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    indegree.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // one element for each course for tracking visiting
        HashMap<Character, Integer> seen = new HashMap<>();

        // stack to hold the visited nodes
        Stack<Character> stack = new Stack<>();

        // for each course, find the visited
        for (Character c : indegree.keySet()) {
            if (!topologicalSort(seen, indegree, c, stack)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        // convert stack to result
        while (!stack.empty())
            sb.append(stack.pop());

        return sb.reverse().toString();

    }


    private boolean topologicalSort(HashMap<Character, Integer> seen,
                                    HashMap<Character, HashSet<Character>> reverseIndex,
                                    Character c,
                                    Stack<Character> stack) {
        if (seen.containsKey(c)) {
            if (seen.get(c) == -1) {
                return false;
            } else {
                return true;
            }
        }

        // currently visiting
        seen.put(c, -1);

        HashSet<Character> vals = reverseIndex.get(c);
        for (Character val : vals) {
            if (!topologicalSort(seen, reverseIndex, val, stack))
                return false;
        }

        // mark as visited
        seen.put(c, 1);

        stack.push(c);
        return true;
    }
}
