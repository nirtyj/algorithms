package com.leetcode.easy;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int backs = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '#') {
                backs++;
                continue;
            } else if (backs > 0) {
                backs--;
                continue;
            } else {
                sb.append(S.charAt(i));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        backs = 0;
        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) == '#') {
                backs++;
                continue;
            } else if (backs > 0) {
                backs--;
                continue;
            } else {
                sb2.append(T.charAt(i));
            }
        }
        return sb2.toString().equals(sb.toString());
    }
}

