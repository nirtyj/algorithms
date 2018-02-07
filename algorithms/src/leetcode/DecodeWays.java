package leetcode;

/**
 * Leetcode verified
 * @author njaganathan
 *
 */
public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;

		// A table to store results of subproblems
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			dp[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if ((s.charAt(i - 1) > '0'))
				dp[i] = dp[i - 1];

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			// or if the last two digits are from 10 - 26, that value is added to the count
			if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
				dp[i] += dp[i - 2];
		}

		return dp[s.length()];
	}
}
