package com.leetcode.dp.palindromicsubsequence;

/**
 * 5. https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring_LC5 {

    /**
     * Leetcode verified - Extend both sides with even and odd
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        char[] word = s.toCharArray();
        String result = "";
        for(int i=0;i<word.length; i++){
            String subString1 =  maxPalindrome(word, i, i);
            String subString2 =  maxPalindrome(word, i, i +1);
            if (subString1.length() > result.length() && subString1.length() > subString2.length()){
                result = subString1;
            } else if (subString2.length() > result.length() && subString2.length() > subString1.length()){
                result = subString2;
            }
        }
        return result;
    }

    String maxPalindrome(char[] arr, int left, int right){
        while(left >= 0 && right <  arr.length && arr[left] == arr[right]){
            left--;
            right++;
        }
        int length = ((right -1) - (left +1))+1;
        return new String(arr, left + 1, length) ;
    }
}
