package com.leetcode.easy;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 */
public class CheckSentenceIsPangram_LC1832 {

    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for(int i =0 ; i< sentence.length();i++){
            int location = sentence.charAt(i) - 'a';
            seen[location] = true;
        }
        for(boolean see : seen){
            if (see == false){
                return false;
            }
        }
        return true;
    }
}
