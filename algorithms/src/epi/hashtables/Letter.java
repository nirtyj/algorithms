package epi.hashtables;

import java.util.HashMap;
import java.util.Map;

public class Letter {

	public static boolean canFormMagazine(String letterWords, String magazineWords) {
		int[] hashMap = new int[256];
		for (int i = 0; i < magazineWords.length(); i++) {
			char c = magazineWords.charAt(i);
			int val = hashMap[Character.toLowerCase(c)];
			hashMap[Character.toLowerCase(c)] = val + 1;
		}

		for (int i = 0; i < letterWords.length(); i++) {
			char c = letterWords.charAt(i);
			int val = hashMap[Character.toLowerCase(c)];
			if (val == 0) {
				return false;
			} else {
				hashMap[Character.toLowerCase(c)] = val - 1;
			}
		}
		return true;
	}

	public static boolean canFormMagazine2(String letterWords, String magazineWords) {
		Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();

		for (int i = 0; i < letterWords.length(); i++) {
			char c = letterWords.charAt(i);
			if (charFrequency.containsKey(c)) {
				int val = charFrequency.get(c);
				charFrequency.put(c, ++val);
			} else {
				charFrequency.put(c, 1);
			}
		}

		for (int i = 0; i < magazineWords.length(); i++) {
			char c = magazineWords.charAt(i);
			if (charFrequency.containsKey(c)) {
				int val = charFrequency.get(c);
				val = val - 1;
				if (val == 0) {
					charFrequency.remove(c);
					if (charFrequency.isEmpty())
						return true;
				} else {
					charFrequency.put(c, val);
				}
			}
		}
		return charFrequency.isEmpty();
	}
}
