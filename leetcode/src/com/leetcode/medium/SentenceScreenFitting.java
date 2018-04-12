package com.leetcode.medium;

/**
Given a rows x cols screen and a sentence represented by a list of non-empty words, 
find how many times the given sentence can be fitted on the screen.

Note:
A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.

Example 1:
Input:
rows = 2, cols = 8, sentence = ["hello", "world"]
Output: 
1
Explanation:
hello---
world---

Example 2:
Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
Output: 
2
Explanation:
a-bcd- 
e-a---
bcd-e-

Example 3:
Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
Output: 
1
Explanation:
I-had
apple
pie-I
had--
*/
public class SentenceScreenFitting {

	/**
	 * Leetcode verified
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int wordsTyping(String[] sentence, int rows, int cols) {
	      String s = String.join(" ", sentence) + " ";
	      int len = s.length();
	      int index = 0;
	      for (int i = 0; i < rows; i++) {
	          index += cols;
	            // if it doesnt end up the end of the word, go back untill you find the 
				// start of the word and continue
	          while (index > 0 && s.charAt(index % len) != ' ')
	              index--;
	          index++;
	      }
	      return index / len;
	}

	/**
	 * Leetcode time limit exceeded
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int wordsTypingTLE2(String[] sentence, int rows, int cols) {
		int i = 0;
		int j = 0;
		int count = 0;
		int wordIndex = 0;
		while (i <= rows - 1 && j <= cols - 1) {
			String word = sentence[wordIndex];
			while (word.length() > (cols - j) && (i <= rows - 1)) {
				i = i + 1;
				j = 0;
			}

			if (i > rows - 1)
				break;

			j = j + word.length();

			if (j == cols) {
				j = 0;
				i = i + 1;
			} else {
				j++;
			}

			if (j > cols - 1) {
				i = i + 1;
				j = 0;
			}

			wordIndex++;
			if (wordIndex == sentence.length) {
				count = count + 1;
				wordIndex = 0;
			}
		}
		return count;
	}

	/**
	 * Leetcode time limit exceeded
	 * 
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public static int wordsTypingTLE(String[] sentence, int rows, int cols) {
		Character[][] matrix = new Character[rows][cols];
		int i = 0;
		int j = 0;
		int count = 0;
		int wordIndex = 0;
		while (i <= rows - 1 && j <= cols - 1) {
			String word = sentence[wordIndex];
			while (word.length() > (cols - j) && (i <= rows - 1)) {
				i = i + 1;
				j = 0;
			}

			if (i > rows - 1)
				break;

			for (int n = 0; n < word.length(); n++) {
				matrix[i][j] = word.charAt(n);
				j++;
			}

			if (j == cols) {
				j = 0;
				i = i + 1;
			} else {
				matrix[i][j] = '-';
				j++;
			}

			if (j > cols - 1) {
				i = i + 1;
				j = 0;
			}

			wordIndex++;
			if (wordIndex == sentence.length) {
				count = count + 1;
				wordIndex = 0;
			}
		}
		return count;
	}
}
