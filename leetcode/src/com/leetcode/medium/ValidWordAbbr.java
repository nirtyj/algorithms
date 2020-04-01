package com.leetcode.medium;

import java.util.HashMap;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * <p>
 * Conditions:
 * They are not the same word. - A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * They both have equal lengths.
 * They both share the same first and last letter.
 */
class ValidWordAbbr {
    HashMap<String, String> dict = new HashMap<>();

    /**
     * Leetcode verified
     *
     * @param dictionary
     */
    public ValidWordAbbr(String[] dictionary) {
        if (dictionary == null || dictionary.length == 0)
            return;
        for (String s : dictionary) {
            String abbr = getAbbreviation(s);
            if (dict.containsKey(abbr)) {
                if (!dict.get(abbr).equals(s)) {
                    dict.put(abbr, "");
                }
            } else {
                dict.put(abbr, s);
            }
        }
    }

    String getAbbreviation(String s) {
        if (s.length() > 2) {
            return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        } else {
            return s;
        }
    }

    public boolean isUnique(String word) {
        return !dict.containsKey(getAbbreviation(word)) || dict.get(getAbbreviation(word)).equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary); boolean param_1 =
 * obj.isUnique(word);
 */
