package epi.hashtables;

public class Palindrome {

	public static boolean canFormPalindrome(String word) {
		int[] hashMap = new int[256];

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == ' ')
				continue;

			hashMap[Character.toLowerCase(c)]++;
		}

		int nonMod2Count = 0;
		for (int i = 0; i < 256; i++) {
			if (hashMap[i] % 2 != 0)
				nonMod2Count++;
		}

		return nonMod2Count <= 1;
	}

}
