package com.leetcode.easy;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
 * if the given words are sorted lexicographicaly in this alien language.
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
public class AlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1)
            return true;

        int maxLength = Integer.MIN_VALUE;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 0; i < maxLength; i++) {
            int prevVal = 0;
            boolean needToLookFurther = false;
            for (int j = 0; j < words.length; j++) {
                if (i >= words[j].length()) {
                    if (prevVal == 0) {
                        continue;
                    } else {
                        return false;
                    }
                }
                // use this instead of hashmap<character, int>
                int currentVal = order.indexOf(words[j].charAt(i));
                if (prevVal > currentVal) {
                    return false;
                } else if (prevVal == currentVal) {
                    // need to check only if some characters are equal in the list
                    // else return all good.
                    needToLookFurther = true;
                }
                prevVal = currentVal;
            }

            if (needToLookFurther == false) {
                return true;
            }
        }
        return true;
    }
}
