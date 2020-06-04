package com.leetcode.dp.palindromicsubsequence;

import java.util.HashMap;

public class LongestPalindromicSubsequence_LC516 {

    /**
     * Bottom up memoization DP with 2D array
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1){
            return 1;
        }
        int[][] memo = new int[s.length()][s.length()];
        char[] word = s.toCharArray();
        // base case of 1 char.
        for(int i=0;i<memo.length;i++){
            memo[i][i] = 1;
        }
        for (int start = word.length-2; start >= 0; start --){
            for (int end = start + 1; end <  word.length; end ++){
                if (word[start] == word[end]){
                    memo[start][end] = 2 + memo[start + 1][end -1];
                } else {
                    memo[start][end] = Math.max(memo[start][end-1], memo[start+1][end]);
                }
            }
        }
        return memo[0][word.length-1];
    }

    /**
     * Top to bottom memoization DP with 2D array
     */
    public int longestPalindromeSubseqTB(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return recurseHelper(s.toCharArray(), 0, s.length() -1, memo);
    }

    public int recurseHelper(char[] word, int startIndex, int endIndex, Integer[][] memo){
        if (startIndex>endIndex){
            return 0;
        }

        Integer stored = memo[startIndex][endIndex];
        if (stored != null){
            return stored;
        }

        if (startIndex == endIndex){
            // base case for 1 element
            memo[startIndex][endIndex] = 1;
        } else if(word[startIndex] == word[endIndex]){
            // if start and end char is same
            memo[startIndex][endIndex] = 2 + recurseHelper(word, startIndex+1, endIndex -1, memo);
        } else {
            // if start and end char is not same, try both options and take max.
            int s1 = recurseHelper(word, startIndex+1, endIndex, memo);
            int s2 = recurseHelper(word, startIndex, endIndex-1, memo);
            memo[startIndex][endIndex] = Math.max(s1, s2);
        }
        return memo[startIndex][endIndex];
    }

    /**
     * Top to Bottom memoization DP with map
     * @param s
     * @return
     */
    public int longestPalindromeSubseqMemoMap(String s) {
        return recurseHelper(s.toCharArray(), 0, s.length() -1, new HashMap<String, Integer>());
    }

    public int recurseHelper(char[] word, int startIndex, int endIndex, HashMap<String, Integer> memo){
        if (startIndex>endIndex){
            return 0;
        }
        String key = getKey(startIndex, endIndex);
        Integer stored = memo.get(key);
        if (stored != null){
            return stored;
        }

        if (startIndex == endIndex){
            memo.put(key, 1);
            return 1;
        }

        if(word[startIndex] == word[endIndex]){
            int result = 2 + recurseHelper(word, startIndex+1, endIndex -1, memo);
            memo.put(key, result);
            return result;
        }

        int s1 = recurseHelper(word, startIndex+1, endIndex, memo);
        int s2 = recurseHelper(word, startIndex, endIndex-1, memo);
        int result = Math.max(s1, s2);
        memo.put(key, result);
        return result;
    }

    private String getKey(Integer start, Integer end){
        return Integer.toString(start) + "->" + Integer.toString(end);
    }
}
