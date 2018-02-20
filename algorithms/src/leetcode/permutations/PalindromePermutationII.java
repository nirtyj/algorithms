package leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
*/
public class PalindromePermutationII {

	private List<String> list = new ArrayList<>();

	/**
	 * 	Leetcode verified
	 *  Need to generate the first part of palindrome string, and the remaining part will be a middle character with the reverse of first part.
	 * @param s
	 * @return
	 */
	public List<String> generatePalindromes(String s) {
		int numOdds = 0; // How many characters that have odd number of count
		int[] map = new int[256]; // Map from character to its frequency
		for (char c : s.toCharArray()) {
			map[c]++;
			// increase for everytime and reduce everytime.. as 2, increase for 1, decrease for 2, increase for 3...
			numOdds = (map[c] & 1) == 1 ? numOdds + 1 : numOdds - 1;
		}
		// If the number of characters with odd number of occurrences exceeds 1, it indicates that no palindromic permutation is possible
		if (numOdds > 1)
			return list;

		String mid = "";
		int length = 0;
		for (int i = 0; i < 256; i++) {
			if (map[i] > 0) {
				if ((map[i] & 1) == 1) { // Char with odd count will be in the middle
					mid = "" + (char) i;
					map[i]--;
				}
				map[i] = map[i]/ 2; // Cut in half since we only generate half string
				length = length + map[i]; // The length of half string
			}
		}
		generatePalindromesHelper(map, length, "", mid);
		return list;
	}

	private void generatePalindromesHelper(int[] map, int length, String s, String mid) {
		if (s.length() == length) {
			StringBuilder reverse = new StringBuilder(s).reverse(); // Second half
			list.add(s + mid + reverse);
			return;
		}
		for (int i = 0; i < 256; i++) { // backtracking just like permutation
			if (map[i] > 0) {
				map[i]--;
				generatePalindromesHelper(map, length, s + (char) i, mid);
				map[i]++;
			}
		}
	}
}
