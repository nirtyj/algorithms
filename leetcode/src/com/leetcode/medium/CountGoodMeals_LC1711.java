package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
 *
 * You can pick any two different foods to make a good meal.
 *
 * Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the number of different good meals you can make from this list modulo 109 + 7.
 *
 * Note that items with different indices are considered different even if they have the same deliciousness value.
 *
 *
 *
 * Example 1:
 *
 * Input: deliciousness = [1,3,5,7,9]
 * Output: 4
 * Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
 * Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.
 * Example 2:
 *
 * Input: deliciousness = [1,1,1,3,3,3,7]
 * Output: 15
 * Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways.
 */
public class CountGoodMeals_LC1711 {
    int mod = 1000000007;
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i=0;i<deliciousness.length;i++){
            int power = 1;
            for (int j = 0; j < 32; j++) {
                int rem = power - deliciousness[i];
                if (map.containsKey(rem)) {
                    total = total + map.get(rem);
                    total = total % mod;
                }
                power = power * 2;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return total % mod;
    }
}
