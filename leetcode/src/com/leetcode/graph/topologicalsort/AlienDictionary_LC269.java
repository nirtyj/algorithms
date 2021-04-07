package com.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
        HashMap<Character, HashSet<Character>> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // invalid order
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    HashSet<Character> ins = inDegree.get(word2.charAt(j));
                    ins.add(word1.charAt(j));
                    break;
                }
            }
        }
        HashMap<Character, Integer> visited = new HashMap<>();
        ArrayList<Character> order = new ArrayList<>();
        for (Character c : inDegree.keySet()) {
            if (!topologicalSort(c, inDegree, visited, order)) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        order.stream().forEach(c -> sb.append(c));
        return sb.toString();
    }

    private boolean topologicalSort(Character key, HashMap<Character, HashSet<Character>> inDegree,
                                    HashMap<Character, Integer> visited, ArrayList<Character> order) {
        if (visited.getOrDefault(key, 0) == -1) {
            return false;
        }
        if (visited.getOrDefault(key, 0) == 1) {
            return true;
        }
        visited.put(key, -1);
        for (Character in : inDegree.get(key)) {
            if (!topologicalSort(in, inDegree, visited, order)) {
                return false;
            }
        }
        visited.put(key, 1);
        order.add(key);
        return true;
    }
}
