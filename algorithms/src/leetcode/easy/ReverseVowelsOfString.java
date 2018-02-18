package leetcode.easy;

import java.util.HashSet;

/**
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/
public class ReverseVowelsOfString {

	/**
	 * Leetcode verified
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseVowels(String s) {
		if (s == null || s.isEmpty() || s.length() == 1)
			return s;

		int start = 0;
		int end = s.length() - 1;
		char[] chars = s.toCharArray();
		HashSet<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');

		while (start < end) {
			while (start < end && !vowels.contains(chars[start])) {
				start++;
			}

			while (end > start && !vowels.contains(chars[end])) {
				end--;
			}

			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;

			start++;
			end--;
		}
		return new String(chars);
	}
}
