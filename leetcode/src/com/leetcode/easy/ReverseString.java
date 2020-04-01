package com.leetcode.easy;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {

    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
