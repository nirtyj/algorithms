package com.leetcode.hard;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 */
public class MinimumWindowSubsequence_LC727 {

    class NextD {
        int length;
        int nextI;

        public NextD(int length, int nextI) {
            this.length = length;
            this.nextI = nextI;
        }
    }

    public String minWindow(String S, String T) {
        int min = 20001;
        String result = "";
        for (int i = S.length() - 1; i >= T.length() - 1; i--) {
            if (S.charAt(i) == T.charAt(T.length() - 1)) {
                NextD res = getMatchedLength(S, i, T);
                if (res.length > 0 && res.length <= min) {
                    min = res.length;
                    result = S.substring(i - res.length + 1, i + 1);
                }
            }
        }
        return result;
    }


    NextD getMatchedLength(String S, int end, String T) {
        int i = end;
        int j = T.length() - 1;
        while (i >= 0 && j >= 0) {
            if (S.charAt(i) == T.charAt(j)) {
                j--;
            }
            i--;
        }
        if (j == -1) {
            return new NextD(end - i, 0);
        } else {
            return new NextD(-1, 0);
        }
    }
}
