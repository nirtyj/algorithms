package com.leetcode.dp;

public class TwoKeysKeyboard {

    /**
     * For generating AAAA we need 2 additional steps from AA.
     * however, to get AAAAAAAA, the most optimal way would be from AAAA, with 2 additional steps (copy-all then paste)
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) { // start from / 2 as thats most likely. no need start from j - 1
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j); // number of times to get to dp[j] + i/j gives you a x number of copy + paste count.
                    break;
                }

            }
        }
        return dp[n];
    }

    /**
     * To get 81 we check
     * if (81 % 2 ==0) No
     * if (81 % 3 ==0) Yes
     * So we need to copy 81/3 = 27 'A's three times (3)
     * Now to get 27 'A's, we need to copy 27/3= 9 'A's three times (3)
     * To get 9 'A's, we need to copy 9/3=3 'A's three times (3)
     * And to get 3 'A's, we need to copy 3/3=1 'A's three times (3)
     * Final answer is 3+3+3+3 = 12
     *
     * Last Example, n=18
     * 18/2 = 9 Copy 9 'A's 2 times (2)
     * 9/3=3 Copy 3 'A's 3 times (3)
     * 3/3=1 Copy 1'A's 3 times (3)
     * Answer: 2+3+3= 8
     * @param n
     * @return
     */
    public int minStepsBest(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n = n / i;
            }
        }
        return res;
    }
}
