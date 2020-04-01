package com.leetcode.permutations;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        return set.size() < 2;
    }
}
