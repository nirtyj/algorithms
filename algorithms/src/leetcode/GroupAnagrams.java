package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			int[] arr = new int[26];
			for (int i = 0; i < str.length(); i++) {
				int val = str.charAt(i) - 'a';
				arr[val]++;
			}
			String ns = new String(Arrays.toString(arr));
			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			// increased the '/u0000' - '/u0001'
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}
			String ns = new String(arr);

			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}
}
