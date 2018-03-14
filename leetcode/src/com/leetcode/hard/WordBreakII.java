package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
public class WordBreakII {

	/**
	 * Leetcode verified
	 * @param s
	 * @param wordDict1
	 * @return
	 */
	public static List<String> wordBreakWorking(String s, List<String> wordDict1) {

		if (s == null || s.isEmpty())
			return Collections.emptyList();

		HashSet<String> wordDict = new HashSet<>(wordDict1);
		HashMap<Integer, List<String>> map = new HashMap<>();

		List<String> emptyStrList = new ArrayList<>();
		emptyStrList.add("");
		map.put(0, emptyStrList);
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(i)) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						List<String> newList = map.get(j);
						if (newList == null)
							newList = new ArrayList<>();
						newList.add(sub);
						map.put(j, newList);
					}
				}
			}
		}

		if (map.containsKey(s.length())) {
			List<String> result = new ArrayList<>();
			dfsCombine(map, result, "", s.length());
			return result;
		} else
			return Collections.emptyList();
	}

	/**
	 * Combine from the right side.
	 * 
	 * @param map
	 * @param result
	 * @param curr
	 * @param i
	 */
	public static void dfsCombine(HashMap<Integer, List<String>> map, List<String> result, String curr, int i) {
		if (i == 0) {
			result.add(curr.trim());
			return;
		}

		if (map.containsKey(i)) {
			for (String s : map.get(i)) {
				String combined = s + " " + curr;
				dfsCombine(map, result, combined, i - s.length());
			}
		}

	}

	/**
	 * Time limit exceeded
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public static List<String> wordBreak(String s, List<String> wordDict) {
		if (s == null || s.isEmpty())
			return Collections.emptyList();
		HashMap<Integer, List<String>> map = new HashMap<>();
		HashSet<String> wordDict1 = new HashSet<>(wordDict);
		List<String> emptyStrList = new ArrayList<>();
		emptyStrList.add("");
		map.put(0, emptyStrList);
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(i)) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict1.contains(sub)) {
						List<String> list = map.get(i);
						List<String> newList = map.get(j);
						if (newList == null)
							newList = new ArrayList<>();
						// maintain the string combinations at each found point.
						// if there is not a match, at the end saves a lot of time to not process this right away
						for (String stringv : list) {
							if (stringv.isEmpty()) {
								stringv = stringv + sub;
							} else {

								stringv = stringv + " " + sub;
							}
							newList.add(stringv);
						}
						map.put(j, newList);
					}
				}
			}
		}

		if (map.containsKey(s.length()))
			return map.get(s.length());
		else
			return Collections.emptyList();
	}

}
