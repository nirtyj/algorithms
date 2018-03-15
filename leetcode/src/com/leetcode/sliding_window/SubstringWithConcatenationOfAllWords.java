package com.leetcode.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/
public class SubstringWithConcatenationOfAllWords {

	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new LinkedList<>();
		if (L.length == 0 || S.length() < L.length * L[0].length())
			return res;
		int N = S.length();
		int M = L.length; // *** length
		int wl = L[0].length();
		Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
		for (String s : L) {
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}
		String str = null, tmp = null;
		for (int i = 0; i < wl; i++) {
			int count = 0; // remark: reset count
			int start = i;
			for (int r = i; r + wl <= N; r += wl) {
				str = S.substring(r, r + wl);
				if (map.containsKey(str)) {
					if (curMap.containsKey(str))
						curMap.put(str, curMap.get(str) + 1);
					else
						curMap.put(str, 1);

					if (curMap.get(str) <= map.get(str))
						count++;
					while (curMap.get(str) > map.get(str)) {
						tmp = S.substring(start, start + wl);
						curMap.put(tmp, curMap.get(tmp) - 1);
						start += wl;

						// the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
						if (curMap.get(tmp) < map.get(tmp))
							count--;

					}
					if (count == M) {
						res.add(start);
						tmp = S.substring(start, start + wl);
						curMap.put(tmp, curMap.get(tmp) - 1);
						start += wl;
						count--;
					}
				} else {
					curMap.clear();
					count = 0;
					start = r + wl;// not contain, so move the start
				}
			}
			curMap.clear();
		}
		return res;
	}
}
