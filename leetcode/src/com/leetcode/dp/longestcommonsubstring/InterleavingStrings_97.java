package com.leetcode.dp.longestcommonsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingStrings_97 {

    /**
     * Top to bottom with individual cases for  {0,0}, {0, 1...n}, {1...n,0}, {1...n, 1...n}
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();
        for(int i=0;i<=s1Arr.length;i++){
            for(int j=0;j<=s2Arr.length;j++){
                if (i==0 && j ==0){ // only for 0,0
                    dp[i][j] = true;
                }else if (i == 0 && s2Arr[j-1] == s3Arr[j-1]){ // only for i=0, j=>1 to n; match only with s2.
                    dp[0][j] = dp[0][j-1]; // if it matches carry over previous value i.e true if the previous is true. ensures always max is captured.
                } else if (j == 0 && s1Arr[i-1] == s3Arr[i-1]){ // only for j=0, i=>1 to n; match only with s1
                    dp[i][0] = dp[i-1][0]; // if it matches carry over previous value i.e true if the previous is true. ensures always max is captured.
                } else if (j>0 && i>0){ // for i=1...n j=1...n
                    if (s2Arr[j-1] == s3Arr[i+j-1]) { // if s2 matches with s3 copy previous s2 value without s3.
                        // if the letter of 's2' and 's3' match, we take whatever is matched till j-1
                        dp[i][j] = dp[i][j-1];
                    }
                    if (s1Arr[i-1] == s3Arr[i+j-1]) { // if s1 matches with s3 copy previous s1 value without s2.
                        // if the letter of 's1' and 's3' match, we take whatever is matched till i-1
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                }
            }
        }
        return dp[s1Arr.length][s2Arr.length];
    }

    /**
     * Recursion with memoization
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveMemo(String s1, String s2, String s3) {
        Map<String, Boolean> dp = new HashMap<String, Boolean>();
        return recurseHelper(s1, s2, s3, 0,0,0,dp);
    }

    private boolean recurseHelper(String s1, String s2, String s3, int i, int j, int k, Map<String, Boolean> dp){
        String key = getKey(i, j, k);
        if (dp.containsKey(key)){
            return dp.get(key);
        }
        if (i == s1.length() && j == s2.length() && k == s3.length()){
            dp.put(key, true);
            return true;
        }
        if (k == s3.length()){
            dp.put(key, false);
            return false;
        }
        boolean matchS1 = false;
        boolean matchS2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            matchS1 = recurseHelper(s1, s2, s3, i+1,j,k+1, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            matchS2 = recurseHelper(s1, s2, s3, i,j+1,k+1, dp);
        }
        dp.put(key, matchS1 || matchS2);
        return matchS1 || matchS2;
    }

    private String getKey(int i, int j, int k) {
        return i + "-" + j + "-" + k;
    }

    /**
     * Exponential - recursion;
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveNaive(String s1, String s2, String s3) {
        return recurseHelper(s1, s2, s3, 0,0,0);
    }

    private boolean recurseHelper(String s1, String s2, String s3, int i, int j, int k){
        if (i == s1.length() && j == s2.length() && k == s3.length()){
            return true;
        }

        if (k == s3.length()){
            return false;
        }

        boolean matchS1 = false;
        boolean matchS2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            matchS1 = recurseHelper(s1, s2, s3, i+1,j,k+1);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            matchS2 = recurseHelper(s1, s2, s3, i,j+1,k+1);
        }
        return matchS1 || matchS2;
    }
}
