package com.leetcode.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1)
            return true;
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            while (i <= j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;

            while (j >= i && !isValidChar(s.charAt(j)))
                j--;

            if (j < i)
                break;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;

            i++;
            j--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');

    }
}
