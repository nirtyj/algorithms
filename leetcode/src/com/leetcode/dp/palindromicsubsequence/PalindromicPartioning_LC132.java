package com.leetcode.dp.palindromicsubsequence;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/gxxqrE2kKrY
 */
public class PalindromicPartioning_LC132 {


    /**
     * Bottom up DP with another array for results
     * @param s
     * @return
     */
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {

            // very important to initialize the max cuts for that start ( end - start - 1)
            cuts[i] = s.length() - i - 1;

            for (int j = i; j < s.length(); j++) {
                // avoids initializing with True as we start from i=j
                if (s.charAt(i) == s.charAt(j)) {

                    // if the diff is less than 2 or diagonal is true, set it to true
                    if (j - i < 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        // if the palindrome is made at the end of the string,
                        if (j == s.length() - 1) {
                            // set the start cut to 0
                            cuts[i] = 0;
                        } else if (cuts[j + 1] + 1 < cuts[i]) {
                            // else, update the start cut to end cut + 1
                            cuts[i] = cuts[j + 1] + 1;
                        }
                    }
                }
            }
        }
        // we maintain the start cut 0 as the min.
        return cuts[0];
    }

    /**
     * Recursion with memoization for both palindrome + min cut results
     */
    public int minCutMemoization(String s) {
        return recurse(s.toCharArray(), 0 , s.length() -1, new Integer[s.length()], new Boolean[s.length()][s.length()]);
    }

    public int recurse(char[] arr, int start, int end,Integer[] resultmemo, Boolean[][] memo){
        if(start >= end || isPalindrome(arr, start, end, memo)) {
            return 0;
        }
        if (resultmemo[start] != null){
            return resultmemo[start];
        }
        int minCuts = end - start;
        for(int i=start;i<=end ;i++){
            if (isPalindrome(arr, start, i, memo)){
                minCuts = Math.min(minCuts, 1 + recurse(arr, i + 1, end, resultmemo, memo));
            }
        }
        resultmemo[start] = minCuts;
        return resultmemo[start];
    }

    public boolean isPalindrome(char[] arr, int start, int end, Boolean[][] memo){
        if (memo[start][end] != null){
            return memo[start][end];
        }
        int prevStart = start;
        int prevEnd = end;
        memo[prevStart][prevEnd] = true;
        while(start<end){
            if (arr[start]!=arr[end]){
                memo[prevStart][prevEnd] = false;
                break;
            }
            start++;
            end--;
            if (start < end && memo[start][end] != null){
                memo[prevStart][prevEnd] = memo[start][end];
                break;
            }
        }
        return memo[prevStart][prevEnd];
    }

    /**
     * Basic Recursion
     * @param s
     * @return
     */
    public int minCutRecursion(String s) {
        return recurse(s.toCharArray(), 0 , s.length());
    }

    public int recurse(char[] arr, int start, int end){
        int minCuts = end - start - 1;
        for(int i=start;i<end ;i++){
            if (isPalindrome(arr, start, i)){
                minCuts = Math.min(minCuts, 1 + recurse(arr, i + 1, end));
            }
        }
        return minCuts;
    }

    public boolean isPalindrome(char[] arr, int start, int end){
        while(start<end ){
            if (arr[start]!=arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
