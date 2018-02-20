package leetcode.easy;

/**
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class ValidAnagram {

	/**
	 * Leetcode verified
	 * @param word1
	 * @param word2
	 * @return
	 */
	public boolean isAnagram(String word1, String word2) {
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
}
