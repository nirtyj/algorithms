package com.leetcode.dp.palindromicsubsequence;

public class CountOfPalindromicSubstrings {

    public int findCPS(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;
        for(int i=0;i<st.length();i++){
            dp[i][i] = true;
            count++;
        }
        for(int start = st.length()-2; start >=0; start --){
            for(int end = start+1; end<st.length(); end++) {
                if(st.charAt(start) == st.charAt(end)) {
                    if (end - start == 1) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                    if (dp[start][end]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountOfPalindromicSubstrings cps = new CountOfPalindromicSubstrings();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
}
