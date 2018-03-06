package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Example 2:

Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Example 3:

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output:
false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.
*/
public class ValidWordSquare {

	/**
	 * Leetcode verified
	 * @param words
	 * @return
	 */
	public static boolean validWordSquare(List<String> words) {

		if (words.size() == 1)
			return true;

		List<StringBuilder> rev = new ArrayList<>();

		int maxLength = 0;
		for (String word : words) {
			maxLength = Math.max(maxLength, word.length());
		}

		for (int i = 0; i < maxLength; i++) {
			rev.add(new StringBuilder());
		}

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				rev.get(i).append(word.charAt(i));
			}
		}

		for (int i = 0; i < words.size(); i++) {
			if (rev.get(i).toString().equals(words.get(i)))
				continue;
			else
				return false;
		}
		return true;
	}
	
	/**
	 * Leetcode verified no extra space
	 * @param words
	 * @return
	 */
	public boolean validWordSquareNoSpace(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}