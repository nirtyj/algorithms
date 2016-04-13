package epi.hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static boolean isAnagram(String word1, String word2) {
		int[] hashMap = new int[256];

		for (int i = 0; i < word1.length(); i++)
			hashMap[word1.charAt(i)]++;

		for (int i = 0; i < word2.length(); i++)
			hashMap[word2.charAt(i)]--;

		for (int i = 0; i < 256; i++) {
			if (hashMap[i] != 0)
				return false;
		}
		return true;
	}

	public static List<List<String>> findAnagrams(List<String> paragraph) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String key : paragraph) {
			char[] arr = key.toCharArray();
			Arrays.sort(arr);
			String sortedKey = new String(arr);
			List<String> entries = map.get(sortedKey);
			if (entries == null)
				entries = new ArrayList<String>();
			entries.add(key);
			map.put(sortedKey, entries);
		}
		List<List<String>> anagramGroups = new ArrayList<List<String>>();
		for (List<String> vals : map.values()) {
			if (vals.size() >= 2)
				anagramGroups.add(vals);
		}
		return anagramGroups;

	}
}
