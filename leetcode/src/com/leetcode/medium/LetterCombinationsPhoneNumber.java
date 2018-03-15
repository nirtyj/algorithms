package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
*/
public class LetterCombinationsPhoneNumber {

	private static final String[] M = new String[] { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV",
			"WXYZ" };

	/**
	 * Leetcode verified
	 * @param phoneNumber
	 * @return
	 */
	public List<String> letterCombinations(String phoneNumber) {
		List<String> words = new ArrayList<>();
		for (int i = 0; i < phoneNumber.length(); i++)
			iterateHelper(phoneNumber, i, words);
		return words;
	}

	private void iterateHelper(String word, int index, List<String> words) {
		int val = Integer.parseInt(word.substring(index, index + 1));
		String map = M[val];
		if (words.isEmpty()) {
			for (String t : map.split("")) {
				words.add(t);
			}
		} else {
			List<String> tempWords = new ArrayList<String>();
			for (String t : map.split("")) {
				for (int i = 0; i < words.size(); i++) {
					String keys = words.get(i);
					String modifiedWord = keys.concat(t);
					tempWords.add(modifiedWord);
				}
			}
			words.clear();
			words.addAll(tempWords);
		}
	}
	

	public List<String> phoneMnemonicRecurse(String phoneNumber) {
		List<String> words = new ArrayList<>();
		char[] chars = new char[phoneNumber.length()];
		recurseHelper(phoneNumber, 0, chars, words);
		return words;
	}

	private void recurseHelper(String word, int index, char[] chars, List<String> words) {

		if (index == word.length()) {
			words.add(new String(chars));
			return;
		}

		int val = Integer.parseInt(word.substring(index, index + 1));
		String map = M[val];

		for (char t : map.toCharArray()) {
			chars[index] = t;
			recurseHelper(word, index + 1, chars, words);
		}
	}

}
