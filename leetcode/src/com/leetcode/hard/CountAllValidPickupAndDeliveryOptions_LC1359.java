package com.leetcode.hard;

/**
 * Given n orders, each order consist in pickup and delivery services.
 *
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
 * Example 2:
 *
 * Input: n = 2
 * Output: 6
 * Explanation: All possible orders:
 * (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
 * This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
 */
public class CountAllValidPickupAndDeliveryOptions_LC1359 {
    /**
     * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/discuss/516968/JavaC%2B%2BPython-Easy-and-Concise
     * Intuition 2
     * We consider the first element in all 2n elements.
     * The first must be a pickup, and we have n pickups as chioce.
     * It's pair can be any positino in the rest of n*2-1 positions.
     * So it's (n * 2 - 1) * n.
     * @param n
     * @return
     */
    public int countOrders(int n) {
        long res = 1, mod = (long)1e9 + 7;
        for (int i = 1; i <= n; ++i)
            res = res * (i * 2 - 1) * i % mod;
        return (int)res;
    }
}
