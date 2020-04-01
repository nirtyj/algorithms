package com.leetcode.buysellstocks;

import java.util.Arrays;

public class BuySellStocks {

    /**
     * Case I: k = 1 - one transaction
     *
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        // day 0 - no stocks
        int oneTransactionHold0 = 0; // no stocks hold 0 - rest - so 0
        int oneTransactionHold1 = Integer.MIN_VALUE; // no stocks hold 1 - impossible - so -infinity

        for (int price : prices) {
            oneTransactionHold0 = Math.max(oneTransactionHold0, oneTransactionHold1 + price); //sell
            oneTransactionHold1 = Math.max(oneTransactionHold1, -price); // buy
        }

        return oneTransactionHold0;
    }

    /**
     * Case III: k = 2 - two transactions
     *
     * @param prices
     * @return
     */
    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int oneTransactionHold0 = 0;
        int oneTransactionHold1 = Integer.MIN_VALUE;
        int twoTransactionHold0 = 0;
        int twoTransactionHold1 = Integer.MIN_VALUE;

        for (int price : prices) {
            twoTransactionHold0 = Math.max(twoTransactionHold0, twoTransactionHold1 + price); // sell
            twoTransactionHold1 = Math.max(twoTransactionHold1, oneTransactionHold0 - price); // buy
            oneTransactionHold0 = Math.max(oneTransactionHold0, oneTransactionHold1 + price); // sell
            oneTransactionHold1 = Math.max(oneTransactionHold1, -price); // buy
        }

        return twoTransactionHold0;
    }

    /**
     * Case IV: k is arbitrary - TLE!! but works
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitIVTLE(int k, int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[] hold0 = new int[k + 1];
        int[] hold1 = new int[k + 1];
        Arrays.fill(hold1, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                hold0[j] = Math.max(hold0[j], hold1[j] + price); // sell
                hold1[j] = Math.max(hold1[j], hold0[j - 1] - price); // buy
            }
        }
        return hold0[k];
    }

    /**
     * Case II: k = +Infinity transactions
     *
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int ktransactionsHold0 = 0;
        int ktransactionsHold1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int prevktransactionsHold0 = ktransactionsHold0;
            ktransactionsHold0 = Math.max(ktransactionsHold0, ktransactionsHold1 + price); // sell
            ktransactionsHold1 = Math.max(ktransactionsHold1, prevktransactionsHold0 - price); // buy
        }

        return ktransactionsHold0;
    }

    /**
     * Case IV: k is arbitrary - k is more than half of prices, then its same as infinite. else its k transactions
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitIV(int k, int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        if (k >= prices.length / 2) {

            int ktransactionsHold0 = 0;
            int ktransactionsHold1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int prevktransactionsHold0 = ktransactionsHold0;
                ktransactionsHold0 = Math.max(ktransactionsHold0, ktransactionsHold1 + price); // sell
                ktransactionsHold1 = Math.max(ktransactionsHold1, prevktransactionsHold0 - price); // buy
            }

            return ktransactionsHold0;
        }

        int[] hold0 = new int[k + 1];
        int[] hold1 = new int[k + 1];
        Arrays.fill(hold1, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                hold0[j] = Math.max(hold0[j], hold1[j] + price); // sell
                hold1[j] = Math.max(hold1[j], hold0[j - 1] - price); // buy
            }
        }
        return hold0[k];
    }

    /**
     * Case V: k = +Infinity but with cooldown
     *
     * @param prices
     * @return
     */
    public int maxProfitV(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int preprevktransactionsHold0 = 0;
        int ktransactionsHold0 = 0;
        int ktransactionsHold1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int prevktransactionsHold0 = ktransactionsHold0;
            ktransactionsHold0 = Math.max(ktransactionsHold0, ktransactionsHold1 + price); // sell
            ktransactionsHold1 = Math.max(ktransactionsHold1, preprevktransactionsHold0 - price); // buy from not pre, but pre-pre
            preprevktransactionsHold0 = prevktransactionsHold0;
        }

        return ktransactionsHold0;
    }

    /**
     * Case VI: k = +Infinity but with transaction fee - pay the fee when buying the stock:
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitV1a(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;

        int ktransactionsHold0 = 0;
        int ktransactionsHold1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int prevktransactionsHold0 = ktransactionsHold0;
            ktransactionsHold0 = Math.max(ktransactionsHold0, ktransactionsHold1 + price); // sell
            ktransactionsHold1 = Math.max(ktransactionsHold1, prevktransactionsHold0 - price - fee); // buy - take out the fees
        }

        return ktransactionsHold0;
    }

    /**
     * Case VI: k = +Infinity but with transaction fee - pay the fee when buying the stock:
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitV1b(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;

        long ktransactionsHold0 = 0;
        long ktransactionsHold1 = Integer.MIN_VALUE;
        for (int price : prices) {
            long prevktransactionsHold0 = ktransactionsHold0;
            ktransactionsHold0 = Math.max(ktransactionsHold0, ktransactionsHold1 + price - fee); // sell - take out the fees
            ktransactionsHold1 = Math.max(ktransactionsHold1, prevktransactionsHold0 - price); // buy
        }
        return (int) ktransactionsHold0;
    }
}
