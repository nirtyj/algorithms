package com.leetcode.hard;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example:
 * Given "bcabc"
 * Return "abc"
 * <p>
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateCharacters {

    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int[] frequency = new int[26];
        for (char c : s.toCharArray())
            frequency[c - 'a']++;

        boolean[] seen = new boolean[26];

        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            frequency[c - 'a']--;
            if (seen[c - 'a'] == true)
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!stack.isEmpty() && stack.peek() > c && frequency[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
