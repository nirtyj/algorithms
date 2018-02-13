package leetcode.hard;

/**
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true -> "c*a*b" could be 0 c 2 a and 1 b, it matched aab.
*/
public class RegularExpressionMatching {

	enum Result {
	    TRUE, FALSE
	}
	
	/**
	 * Leetcode verified
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean isMatch(String text, String pattern) {

		// start with pattern is empty
		if (pattern == null || pattern.isEmpty())
			return text.isEmpty(); // text should be also empty. if not fail

		// first character matches of the pattern
		boolean firstCharMatch = !text.isEmpty()
				&& ((pattern.charAt(0) == '.')|| (pattern.charAt(0) == text.charAt(0)));

		// if its more than equals 2 & has a *, means special case. can be 0 or more preceding element
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			// isMatch(text, pattern.substring(2)) - 0 case
			// firstchar match + isMatch(text.substring(1), pattern) -> multiple matches
			return isMatch(text, pattern.substring(2)) || (firstCharMatch && isMatch(text.substring(1), pattern));
		} else {
			// first matches, go check the remaining
			return firstCharMatch && isMatch(text.substring(1), pattern.substring(1));
		}
	}

	Result[][] memo;

	/**
	 * Leetcode verified
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean isMatchMemo(String text, String pattern) {
		memo = new Result[text.length() + 1][pattern.length() + 1];
		return dp(0, 0, text, pattern);
	}

	public boolean dp(int i, int j, String text, String pattern) {
		// if its not already found out return the existing value
		if (memo[i][j] != null) {
			return memo[i][j] == Result.TRUE;
		}
		boolean ans;
		// pattern is empty, answer = is text should also be empty
		if (j == pattern.length()) {
			ans = (i == text.length());
		} else {
			// first character matches
			boolean first_match = (i < text.length()
					&& (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
			// special case, for <x>*
			if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
				// dp(i, j + 2, text, pattern)  - 0 case
				// firstcharmatch + multiple char matches - dp(i + 1, j, text, pattern)
				ans = dp(i, j + 2, text, pattern) || first_match && dp(i + 1, j, text, pattern);
			} else {
				// else first char match && remaining
				ans = first_match && dp(i + 1, j + 1, text, pattern);
			}
		}
		memo[i][j] = ans ? Result.TRUE : Result.FALSE;
		return ans;
	}
}
